package com.example.demo.repository

import com.example.demo.entity.EventEntity
import com.example.demo.enum.EventStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface EventRepository : JpaRepository<EventEntity, Long> {
    fun findByStatus(status: EventStatus): List<EventEntity>

    @Query("update EventEntity e set e.status = ?1 where e.id = ?2")
    @Modifying
    fun updateStatus(status: EventStatus, id: Long)
}