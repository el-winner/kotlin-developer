package com.example.demo.service

import com.example.demo.dto.RequestPersonDto
import com.example.demo.dto.ResponsePersonDto
import com.example.demo.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
        private val personDataEnricherClient: PersonDataEnricherClient,
        private val personRepository: PersonRepository
) {

    fun addPerson(requestPersonDto: RequestPersonDto): ResponsePersonDto {
        val responsePersonDto = personDataEnricherClient.enrichPersonData(requestPersonDto)
        personRepository.addPerson(responsePersonDto)
        return responsePersonDto
    }

    fun getPerson(id: Long) =
            personRepository.getPerson(id)

    fun getAllByAge(age: Int) =
            personRepository.getAllByAge(age)
}