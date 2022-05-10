package com.example.demo.util

import com.example.demo.entity.EventEntity
import com.example.demo.model.EventModel

fun EventEntity.toModel() =
    EventModel(
        this.id!!,
        this.type,
        this.body,
        this.status
    )