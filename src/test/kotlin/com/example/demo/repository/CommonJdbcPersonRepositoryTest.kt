package com.example.demo.repository

import com.example.demo.domain.PersonModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@JdbcTest
internal class CommonJdbcPersonRepositoryTest {

    @Autowired
    private lateinit var ds: DataSource

    private lateinit var commonJdbcPersonRepository: CommonJdbcPersonRepository

    @BeforeEach
    fun setUp() {
        commonJdbcPersonRepository = CommonJdbcPersonRepository(JdbcTemplate(ds))
    }

    @Test
    fun getPerson() {
        // when
        val result = commonJdbcPersonRepository.getPerson(1)

        // then
        assertEquals("Petya", result.name)
        assertEquals(20, result.age)
    }

    @Test
    fun getPersons() {
        // when
        val result = commonJdbcPersonRepository.getPersons()

        // then
        assertEquals(2, result.size)
    }

    @Test
    fun getPersonsByAge() {
        // when
        val result = commonJdbcPersonRepository.getPersonsByAge(20)

        // then
        assertEquals(1, result.size)
        assertEquals("Petya", result[0].name)
        assertEquals(20, result[0].age)
    }

    @Test
    fun savePerson() {
        // when
        commonJdbcPersonRepository.savePerson(PersonModel(name = "Kolya", age = 40))

        // then
        assertEquals(3, commonJdbcPersonRepository.getPersons().size)
        assertEquals("Kolya", commonJdbcPersonRepository.getPersons()[2].name)
        assertEquals(3, commonJdbcPersonRepository.getPersons()[2].id)
    }
}
