package com.example.demo

import com.example.demo.config.HttpClientConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(HttpClientConfig::class)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
