package com.example.demo.service

import com.example.demo.client.PersonClient
import com.example.demo.dto.PersonRequest
import com.example.demo.dto.PersonResponse
import com.example.demo.repository.PersonRepository
import com.example.demo.utils.toModel
import com.example.demo.utils.toPerson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personClient: PersonClient,
    private val personRepository: PersonRepository
) {

    fun getPerson(id: Long): PersonResponse {
        return personRepository.findById(id).get().toPerson()
    }

    fun savePerson(person: PersonRequest) {
        CoroutineScope(Dispatchers.Default).launch {
            val enrichedPerson = personClient.enrichPerson(person)
            withContext(Dispatchers.IO) {
                personRepository.save(enrichedPerson.toModel())
            }
        }
    }
}
