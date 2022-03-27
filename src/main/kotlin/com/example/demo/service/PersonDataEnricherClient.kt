package com.example.demo.service

import com.example.demo.dto.RequestPersonDto
import com.example.demo.dto.ResponsePersonDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PersonDataEnricherClient(
        private val restTemplate: RestTemplate
) {
    @Value("\${some.url}")
    private lateinit var URL: String

    fun enrichPersonData(requestPersonDto: RequestPersonDto) =
            restTemplate.postForEntity(URL, requestPersonDto, ResponsePersonDto::class.java).body
                    ?: throw IllegalStateException("Не удалось обогатить данные человека")
}
