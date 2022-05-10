package com.example.demo.entity

import com.example.demo.enum.EventStatus
import com.example.demo.enum.EventType
import javax.persistence.*

@Table(name = "events")
@Entity
class EventEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    var id: Long? = null,

    @Column(name = "event_type")
    @Enumerated(value = EnumType.STRING)
    val type: EventType,

    @Column(name = "event_body")
    val body: String,

    @Column(name = "event_status")
    @Enumerated(value = EnumType.STRING)
    var status: EventStatus
)
