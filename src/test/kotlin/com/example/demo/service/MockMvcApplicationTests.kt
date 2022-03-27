package com.example.demo.service

import com.example.demo.dto.RequestPersonDto
import com.example.demo.dto.ResponsePersonDto
import com.example.demo.repository.PersonRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class MockMvcApplicationTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private val objectMapper = ObjectMapper()

    @MockkBean
    private lateinit var personDataEnricherClient: PersonDataEnricherClient

    @MockkBean
    private lateinit var personRepository: PersonRepository

    @Test
    fun `should return person added to list`() {
        every { personDataEnricherClient.enrichPersonData(any()) } returns responsePersonDto
        every { personRepository.addPerson(any()) } returns Unit

        mockMvc.perform(post("/persons/add")
                .content(objectMapper.writeValueAsString(requestPersonDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.nameInCyrillic").value("Иван"))
                .andExpect(jsonPath("$.nameInLatin").value("Ivan"))
                .andExpect(jsonPath("$.age").value("24"))
    }

    @Test
    fun `should get person successfully`() {
        every { personRepository.getPerson(any()) } returns responsePersonDto

        mockMvc.perform(get("/persons/get/0"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.nameInCyrillic").value("Иван"))
                .andExpect(jsonPath("$.nameInLatin").value("Ivan"))
                .andExpect(jsonPath("$.age").value("24"))
    }

    @Test
    fun `should return error message when getPerson() fails`() {
        every { personRepository.getPerson(any()) } throws illegalArgumentException

        mockMvc.perform(get("/persons/get/0"))
                .andExpect(status().is4xxClientError)
                .andExpect(content().string(containsString("Человек с данным id не найден")))
    }

    @Test
    fun `should return list of persons of same age`() {
        every { personRepository.getAllByAge(any()) } returns list

        mockMvc.perform(get("/persons/getAllByAge")
                .param("age", "24"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$[0].nameInCyrillic").value("Иван"))
                .andExpect(jsonPath("$[0].nameInLatin").value("Ivan"))
                .andExpect(jsonPath("$[0].age").value("24"))
                .andExpect(jsonPath("$[1].nameInCyrillic").value("Сергей"))
                .andExpect(jsonPath("$[1].nameInLatin").value("Sergey"))
                .andExpect(jsonPath("$[1].age").value("24"))
    }

    @Test
    fun `should return error message when getAllByAge() fails`() {
        every { personRepository.getAllByAge(any()) } throws illegalStateException

        mockMvc.perform(get("/persons/getAllByAge")
                .param("age", "24"))
                .andExpect(status().is5xxServerError)
                .andExpect(content().string(containsString("Людей данного возраста не найдено")))
    }

    companion object {
        private val requestPersonDto = RequestPersonDto("Иван", 24)
        private val responsePersonDto = ResponsePersonDto("Иван", "Ivan", 24)
        private val illegalArgumentException = IllegalArgumentException("Человек с данным id не найден")
        private val list = listOf(
                ResponsePersonDto("Иван", "Ivan", 24),
                ResponsePersonDto("Сергей", "Sergey", 24),
                ResponsePersonDto("Андрей", "Andrey", 25)
        )
        private val illegalStateException = IllegalStateException("Людей данного возраста не найдено")
    }
}
