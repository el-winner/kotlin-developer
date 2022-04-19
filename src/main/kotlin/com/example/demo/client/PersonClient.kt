package com.example.demo.client

import com.example.demo.config.WebClientConfig
import com.example.demo.dto.EnrichedPerson
import com.example.demo.dto.PersonRequest
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import reactor.core.publisher.Mono

@Component
class PersonClient(
    private val webClientConfig: WebClientConfig
) {

    private final var client: WebClient =
        WebClient.builder()
            .baseUrl(webClientConfig.baseUrl)
            .build()

    suspend fun enrichPerson(person: PersonRequest): EnrichedPerson {
        return client.post()
            .uri(webClientConfig.enrichPersonUri)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(person), PersonRequest::class.java)
            .retrieve()
            .awaitBody()
    }
}
