package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(basePackages = ["com.example.demo"])
class JdbcConfig {

    @Bean
    fun jdbcTemplate(dataSource: DataSource) = JdbcTemplate(dataSource)
}
