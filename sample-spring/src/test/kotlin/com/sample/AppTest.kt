package com.sample

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AppTest {

    @Test
    fun contextLoad() {
        println("Context loaded")
    }
}