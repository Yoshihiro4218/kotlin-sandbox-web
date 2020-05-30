package com.example.sandbox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class SandboxApplication

fun main(args: Array<String>) {
	runApplication<SandboxApplication>(*args)
}
