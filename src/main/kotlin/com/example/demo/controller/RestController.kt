package com.example.demo.controller

import com.example.demo.dto.PersonRequest
import com.example.demo.dto.PersonResponse
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
        @RequestBody personRequest: PersonRequest
    ): PersonResponse =
        personService.addPerson(personRequest)

    @GetMapping("/get/{id}")
    fun getPerson(
        @PathVariable id: Long
    ): PersonResponse =
        personService.getPerson(id)

    @GetMapping("/getAllByAge")
    fun getAllByAge(
        @RequestParam age: Int
    ): Collection<PersonResponse> =
        personService.getAllByAge(age)
}
