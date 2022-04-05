package com.example.demo.repository

import com.example.demo.domain.PersonModel
import org.springframework.data.jpa.repository.JpaRepository

interface JpaPersonRepository : JpaRepository<PersonModel, Long> {
    fun findByAge(age: Int): List<PersonModel>
}
