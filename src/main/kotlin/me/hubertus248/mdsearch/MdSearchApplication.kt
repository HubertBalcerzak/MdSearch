package me.hubertus248.mdsearch

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.PropertySource

@PropertySource("application.properties")
@SpringBootApplication
class MdSearchApplication

fun main(args: Array<String>) {
    SpringApplication.run(MdSearchApplication::class.java, *args)
}
