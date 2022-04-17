package com.example.demo.utils

import com.example.demo.domain.PersonModel
import com.example.demo.dto.EnrichedPerson
import com.example.demo.dto.Person

fun EnrichedPerson.toModel(): PersonModel {
    return PersonModel(
            name = name,
            age = age,
            salary = salary
    )
}

fun PersonModel.toPerson(): Person {
    return Person(
            name = name,
            age = age
    )
}
