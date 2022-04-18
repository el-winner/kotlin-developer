package com.example.demo.controller

import com.example.demo.dto.PersonRequest
import com.example.demo.dto.PersonResponse
import com.example.demo.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(
        private val personService: PersonService
) {

    @GetMapping("my-persons/{id}")
    fun getPerson(@PathVariable id: Long): PersonResponse {
        return personService.getPerson(id)
    }

    @PostMapping("my-persons")
    fun savePerson(person: PersonRequest) {
        personService.savePerson(person)
    }
}
