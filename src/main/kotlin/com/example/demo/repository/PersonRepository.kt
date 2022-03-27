package com.example.demo.repository

import com.example.demo.domain.PersonResponseModel
import org.springframework.stereotype.Repository

@Repository
class PersonRepository {

    private val persons = mutableMapOf<Long, PersonResponseModel>()
    private var id = -1L

    fun addPerson(personResponseModel: PersonResponseModel) {
        persons[++id] = personResponseModel
    }

    fun getPerson(id: Long) =
        persons[id] ?: throw IllegalArgumentException("Человек с данным id не найден")

    fun getAllByAge(age: Int) = persons
        .filter { it.value.age == age }.values
        .ifEmpty { throw IllegalArgumentException("Людей данного возраста не найдено") }
}
