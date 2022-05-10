package com.example.demo.service

import com.example.demo.model.EventModel
import org.springframework.stereotype.Service

@Service
class PushProcessor : CommonProcessor {
    override fun handleEvent(event: EventModel) {
        println("Hello from PUSH service")
    }
}