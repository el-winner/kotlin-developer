package com.example.demo.client

import com.example.demo.config.WebClientConfig
import com.example.demo.dto.EnrichedPerson
import com.example.demo.dto.Person
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class PersonClient(
        private val webClientConfig: WebClientConfig
) {

    private final var client: WebClient =
            WebClient.builder()
                    .baseUrl(webClientConfig.baseUrl)
                    .build()

    fun enrichPerson(person: Person): EnrichedPerson {
        return runCatching {
            client.post()
                    .uri(webClientConfig.enrichPersonUri)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(Mono.just(person), Person::class.java)
                    .retrieve()
                    .bodyToMono(EnrichedPerson::class.java)
                    .block()
        }.getOrNull() ?: throw Exception("Some problem in external service")
    }
}
