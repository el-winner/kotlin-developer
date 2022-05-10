package com.example.demo.service

import com.example.demo.model.EventModel

interface CommonProcessor {
    fun handleEvent(event: EventModel)
}