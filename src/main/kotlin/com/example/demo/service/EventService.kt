package com.example.demo.service

import com.example.demo.enum.EventStatus
import com.example.demo.model.EventModel
import com.example.demo.repository.EventRepository
import com.example.demo.util.toModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EventService(
    private val eventRepository: EventRepository
) {
    fun getNewEvents() =
        eventRepository.findByStatus(EventStatus.NEW).map { it.toModel() }

    @Transactional
    fun updateStatus(event: EventModel, status: EventStatus) {
        eventRepository.updateStatus(status, event.id)
    }
}