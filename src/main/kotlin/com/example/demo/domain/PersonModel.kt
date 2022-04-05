package com.example.demo.domain

import javax.persistence.*

@Table(name = "persons")
@Entity
data class PersonModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "person_name")
    val name: String,

    @Column(name = "age")
    val age: Int
)

