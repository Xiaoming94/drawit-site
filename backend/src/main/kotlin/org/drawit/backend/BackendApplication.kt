package org.drawit.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}

@Configuration
//The next line tells Spring Generate our JPA Repositories
@EnableJpaRepositories(basePackages = ["org.drawit.backend"])
class Config