package com.example.demo.config

import com.example.demo.repository.CommonJdbcPersonRepository
import com.example.demo.repository.CommonJpaPersonRepository
import com.example.demo.repository.JpaPersonRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate

@Configuration
class BeanConfig {

    @Primary
    @Bean
    fun commonJdbcPersonRepository(jdbcTemplate: JdbcTemplate) =
        CommonJdbcPersonRepository(jdbcTemplate)

    @Bean
    fun commonJpaPersonRepository(jpaPersonRepository: JpaPersonRepository) =
        CommonJpaPersonRepository(jpaPersonRepository)
}
