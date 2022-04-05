package com.example.demo.controller

import com.example.demo.dto.Person
import com.example.demo.service.PersonService
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/persons")
class RestController(
    private val personService: PersonService
) {

    @PostMapping("/add")
    fun addPerson(
        @RequestBody person: Person
    ) {
        personService.savePerson(person)
    }

    @GetMapping("/get/{id}")
    fun getPerson(
        @PathVariable id: Long
    ): Person =
        personService.getPerson(id)

    @GetMapping("/getAll")
    fun getAllPersons(): List<Person> =
        personService.getPersons()

    @GetMapping("/getAllByAge")
    fun getAllByAge(
        @RequestParam age: Int
    ): List<Person> =
        personService.getPersonsByAge(age)
}
