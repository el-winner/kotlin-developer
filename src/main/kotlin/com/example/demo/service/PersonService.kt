package com.example.demo.service

import com.example.demo.dto.PersonRequest
import com.example.demo.dto.PersonResponse
import com.example.demo.repository.PersonRepository
import com.example.demo.util.toDto
import com.example.demo.util.toModel
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personDataEnricherClient: PersonDataEnricherClient,
    private val personRepository: PersonRepository
) {

    fun addPerson(personRequest: PersonRequest): PersonResponse {
        val personResponse = personDataEnricherClient.enrichPersonData(personRequest)
        val responsePersonModel = personResponse.toModel()
        personRepository.addPerson(responsePersonModel)
        return personResponse
    }

    fun getPerson(id: Long) =
        personRepository.getPerson(id).toDto()

    fun getAllByAge(age: Int, page: Int, size: Int) =
        personRepository.getAllByAge(age, page, size).map { it.toDto() }

    fun getNumberOfPersons() = personRepository.getNumberOfPersons()

}
