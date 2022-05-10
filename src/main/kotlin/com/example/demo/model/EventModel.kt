package com.example.demo.model

import com.example.demo.enum.EventStatus
import com.example.demo.enum.EventType
import java.io.Serializable

data class EventModel(
    val id: Long,
    val type: EventType,
    val body: String,
    var status: EventStatus
) : Serializable