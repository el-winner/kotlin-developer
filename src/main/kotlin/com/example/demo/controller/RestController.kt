package com.example.demo.controller

import com.example.demo.dto.RequestPersonDto
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
            @RequestBody requestPersonDto: RequestPersonDto
    ) = personService.addPerson(requestPersonDto)

    @GetMapping("/get/{id}")
    fun getPerson(
            @PathVariable id: Long
    ) = personService.getPerson(id)

    @GetMapping("/getAllByAge")
    fun getAllByAge(
            @RequestParam age: Int
    ) = personService.getAllByAge(age)
}