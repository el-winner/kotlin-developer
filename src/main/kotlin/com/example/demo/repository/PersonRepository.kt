package com.example.demo.repository

import com.example.demo.domain.PersonModel


interface PersonRepository {
    fun getPerson(id: Long): PersonModel

    fun getPersons(): List<PersonModel>

    fun getPersonsByAge(age: Int): List<PersonModel>

    fun savePerson(person: PersonModel)
}
