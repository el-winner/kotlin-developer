package com.example.demo.repository

import com.example.demo.domain.PersonModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.DirtiesContext

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
internal class CommonJpaPersonRepositoryTest {

    @Autowired
    private lateinit var jpaPersonRepository: JpaPersonRepository

    @BeforeEach
    fun setUp() {
        jpaPersonRepository.save(PersonModel(name = "Petya", age = 20))
        jpaPersonRepository.save(PersonModel(name = "Katya", age = 30))
    }

    @Test
    fun getPerson() {
        // when
        val result = jpaPersonRepository.findById(1).get()

        // then
        assertEquals("Petya", result.name)
        assertEquals(20, result.age)
    }

    @Test
    fun getPersons() {
        // when
        val result = jpaPersonRepository.findAll()

        // then
        assertEquals(2, result.size)
    }

    @Test
    fun getPersonsByAge() {
        // when
        val result = jpaPersonRepository.findByAge(20)

        // then
        assertEquals(1, result.size)
        assertEquals("Petya", result[0].name)
        assertEquals(20, result[0].age)
    }

    @Test
    fun savePerson() {
        // when
        jpaPersonRepository.save(PersonModel(name = "Kolya", age = 40))

        // then
        assertEquals(3, jpaPersonRepository.findAll().size)
        assertEquals("Kolya", jpaPersonRepository.findAll()[2].name)
        assertEquals(3, jpaPersonRepository.findAll()[2].id)
    }
}
