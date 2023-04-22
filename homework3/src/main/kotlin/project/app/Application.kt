package project.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication(scanBasePackages = ["project"])
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = ["project.jpa"])
@EntityScan(basePackages = ["project.models"])
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}