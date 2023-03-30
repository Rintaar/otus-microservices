package project.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["project"])
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}