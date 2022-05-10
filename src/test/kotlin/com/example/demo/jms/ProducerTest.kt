package com.example.demo.jms

import com.example.demo.entity.EventEntity
import com.example.demo.enum.EventStatus
import com.example.demo.enum.EventType
import com.example.demo.repository.EventRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.Thread.sleep

@SpringBootTest
internal class ProducerTest {

    @Autowired
    private lateinit var producer: Producer

    @Autowired
    private lateinit var eventRepository: EventRepository

    @BeforeEach
    fun setUp() {
        eventRepository.save(
            EventEntity(
                1,
                EventType.EMAIL,
                "Hello from email",
                EventStatus.NEW
            )
        )
    }

    @Test
    fun `should update event status from NEW to DONE`() {
        // when
        producer.produceEvents()
        sleep(200)

        // then
        val result = eventRepository.findById(1).get()
        Assertions.assertAll(
            { assertEquals("Hello from email", result.body) },
            { assertEquals(EventStatus.DONE, result.status) },
            { assertEquals(EventType.EMAIL, result.type) }
        )
    }
}