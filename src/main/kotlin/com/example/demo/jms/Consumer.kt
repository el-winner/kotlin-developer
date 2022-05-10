package com.example.demo.jms

import com.example.demo.enum.EventStatus
import com.example.demo.enum.EventType
import com.example.demo.model.EventModel
import com.example.demo.service.EmailProcessor
import com.example.demo.service.EventService
import com.example.demo.service.PushProcessor
import com.example.demo.service.SmsProcessor
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class Consumer(
    private val emailProcessor: EmailProcessor,
    private val pushProcessor: PushProcessor,
    private val smsProcessor: SmsProcessor,
    private val eventService: EventService
) {

    @JmsListener(destination = "event.queue")
    fun consumeEvents(event: EventModel) {
        when (event.type) {
            EventType.SMS -> smsProcessor.handleEvent(event)
            EventType.EMAIL -> emailProcessor.handleEvent(event)
            EventType.PUSH -> pushProcessor.handleEvent(event)
        }
        eventService.updateStatus(event, EventStatus.DONE)
    }
}