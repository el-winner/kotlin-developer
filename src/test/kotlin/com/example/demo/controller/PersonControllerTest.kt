package com.example.demo.controller

import com.example.demo.client.PersonClient
import com.example.demo.dto.EnrichedPerson
import com.ninjasquad.springmockk.MockkBean
import io.mockk.coEvery
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PersonControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean(relaxed = true, relaxUnitFun = true)
    private lateinit var personClient: PersonClient

    @BeforeAll
    fun setUp() {
        coEvery { personClient.enrichPerson(any()) } returns EnrichedPerson(
            "Katya", 25, 2000
        )
        runBlocking {
            mockMvc.perform(
                post("/my-persons")
                    .param("name", "Katya")
                    .param("age", "25")
            )
        }
    }

    @Test
    fun `should post object successfully`() {
        mockMvc.perform(
            post("/my-persons")
                .param("name", "Katya")
                .param("age", "25")
        ).andExpect(status().isOk)
    }

    @Test
    fun `should get object successfully`() {
        mockMvc.perform(get("/my-persons/1"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("25")))
            .andExpect(content().string(containsString("Katya")))
    }
}
