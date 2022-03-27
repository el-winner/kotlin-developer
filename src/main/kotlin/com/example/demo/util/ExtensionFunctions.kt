package com.example.demo.util

import com.example.demo.domain.PersonResponseModel
import com.example.demo.dto.PersonResponse

fun PersonResponse.toModel(): PersonResponseModel =
    PersonResponseModel(
        this.nameInCyrillic,
        this.nameInLatin,
        this.age
    )

fun PersonResponseModel.toDto(): PersonResponse =
    PersonResponse(
        this.nameInCyrillic,
        this.nameInLatin,
        this.age
    )
