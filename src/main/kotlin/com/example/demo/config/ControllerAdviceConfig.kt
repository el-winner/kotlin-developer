package com.example.demo.config

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdviceConfig {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(e: Exception): String {
        log.error(e.message, e)
        return "Пожалуйста, зайдите позже"
    }

    companion object {
        private val log = LoggerFactory.getLogger(ControllerAdviceConfig::class.java)
    }
}
