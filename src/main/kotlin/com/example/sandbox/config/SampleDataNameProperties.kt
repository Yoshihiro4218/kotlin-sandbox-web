package com.example.sandbox.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "filename")
@ConstructorBinding
data class SampleDataNameProperties(
        val entities: List<String>
)