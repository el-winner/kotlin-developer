package com.example.demo.repository

import com.example.demo.domain.PersonModel
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<PersonModel, Long>