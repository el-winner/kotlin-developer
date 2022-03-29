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

    fun getAllByAge(age: Int, page: Int, size: Int) =
        persons.values
            .asSequence()
            .filter { it.age == age }
            .drop(size * (page - 1))
            .take(size)
            .toList()
            .ifEmpty { throw IllegalArgumentException("Людей данного возраста не найдено") }

    fun getNumberOfPersons() =
        persons.size
}
