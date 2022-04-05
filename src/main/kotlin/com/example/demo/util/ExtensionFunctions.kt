package com.example.demo.util

import com.example.demo.domain.PersonModel
import com.example.demo.dto.Person

fun Person.toModel(): PersonModel =
    PersonModel(
        name = this.name,
        age = this.age
    )

fun PersonModel.toDto(): Person =
    Person(
        this.name,
        this.age
    )
