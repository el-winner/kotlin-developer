package com.example.demo.controller

import com.example.demo.dto.Person
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
    fun getPerson(@PathVariable id: Long): Person {
        return personService.getPerson(id)
    }

    @PostMapping("my-persons")
    fun savePerson(person: Person) {
        personService.savePerson(person)
    }
}