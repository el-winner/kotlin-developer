package com.example.demo.service

import com.example.demo.config.HttpClientConfig
import com.example.demo.dto.PersonRequest
import com.example.demo.dto.PersonResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PersonDataEnricherClient(
    private val restTemplate: RestTemplate,
    private val httpClientConfig: HttpClientConfig
) {

    fun enrichPersonData(personRequest: PersonRequest) =
        restTemplate.postForEntity(
            httpClientConfig.url,
            personRequest,
            PersonResponse::class.java
        ).body
            ?: throw IllegalStateException("Не удалось обогатить данные человека")
}
