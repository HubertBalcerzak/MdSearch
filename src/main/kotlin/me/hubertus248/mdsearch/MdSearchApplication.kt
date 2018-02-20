package me.hubertus248.mdsearch

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MdSearchApplication

fun main(args: Array<String>) {
    SpringApplication.run(MdSearchApplication::class.java, *args)
}
