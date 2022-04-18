package com.example.demo.client

import com.example.demo.config.WebClientConfig
import com.example.demo.dto.EnrichedPerson
import com.example.demo.dto.PersonRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
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

    suspend fun enrichPersonAsync(person: PersonRequest): Deferred<Mono<EnrichedPerson>> {
        val deferred = CoroutineScope(Dispatchers.Default).async {
            client.post()
                .uri(webClientConfig.enrichPersonUri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(person), PersonRequest::class.java)
                .retrieve()
                .bodyToMono(EnrichedPerson::class.java)
        }
        return deferred
    }
}
