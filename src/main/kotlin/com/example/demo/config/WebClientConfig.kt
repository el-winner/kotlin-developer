package com.example.demo.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "web-client")
data class WebClientConfig(
        val baseUrl: String,
        val enrichPersonUri: String
)