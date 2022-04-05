package com.example.demo.service

import com.example.demo.dto.Person
import com.example.demo.repository.PersonRepository
import com.example.demo.util.toDto
import com.example.demo.util.toModel
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personRepository: PersonRepository
) {

    fun savePerson(person: Person) {
        personRepository.savePerson(person.toModel())
    }

    fun getPerson(id: Long) =
        personRepository.getPerson(id).toDto()

    fun getPersons() =
        personRepository.getPersons().map { it.toDto() }

    fun getPersonsByAge(age: Int) =
        personRepository.getPersonsByAge(age).map { it.toDto() }
}
