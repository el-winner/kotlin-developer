package com.example.demo.repository

import com.example.demo.domain.PersonModel
import org.springframework.stereotype.Repository

//@Primary
@Repository
class CommonJpaPersonRepository(
    private val jpaPersonRepository: JpaPersonRepository
) : PersonRepository {
    override fun getPerson(id: Long): PersonModel {
        return jpaPersonRepository.findById(id).get()
    }

    override fun getPersons(): List<PersonModel> {
        return jpaPersonRepository.findAll()
    }

    override fun getPersonsByAge(age: Int): List<PersonModel> {
        return jpaPersonRepository.findByAge(age)
    }

    override fun savePerson(person: PersonModel) {
        jpaPersonRepository.save(person)
    }
}
