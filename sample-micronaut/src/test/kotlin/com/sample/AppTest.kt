package com.sample

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class AppTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Test
    fun contextLoad() {
        Assertions.assertTrue(application.isRunning)
    }

}