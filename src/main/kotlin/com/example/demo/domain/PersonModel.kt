package com.example.demo.domain

import javax.persistence.*

@Table(name = "my_persons")
@Entity
class PersonModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "person_id")
        var id: Long? = null,

        @Column(name = "person_name")
        val name: String,

        @Column(name = "person_age")
        val age: Int,

        @Column(name = "person_salary")
        val salary: Int
)
