package com.example.demo.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.convert.DurationUnit
import java.time.Duration
import java.time.temporal.ChronoUnit

@ConstructorBinding
@ConfigurationProperties(prefix = "http-client")
data class HttpClientConfig(
    @DurationUnit(ChronoUnit.SECONDS) val connectTimeout: Duration,
    @DurationUnit(ChronoUnit.SECONDS) val readTimeout: Duration,
    val url: String
)
