package com.example.demo.jms

import com.example.demo.enum.EventStatus
import com.example.demo.service.EventService
import org.apache.activemq.command.ActiveMQQueue
import org.springframework.jms.JmsException
import org.springframework.jms.core.JmsTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Producer(
    private val eventService: EventService,
    private val queue: ActiveMQQueue,
    private val jmsTemplate: JmsTemplate
) {

    @Scheduled(cron = "0 0 */1 * * *")
    fun produceEvents() {
        val newEvents = eventService.getNewEvents()
        newEvents.map {
            val event = it
            eventService.updateStatus(event, EventStatus.IN_PROCESS)
            try {
                jmsTemplate.convertAndSend(queue, event)
            } catch (e: JmsException) {
                eventService.updateStatus(event, EventStatus.ERROR)
            }
        }
    }
}