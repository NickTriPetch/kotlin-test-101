package com.nick.kotlintest101

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ExampleIntegrationTest {
    @Test
    fun `should be true when it is true`() {
        Assertions.assertThat(true).isTrue()
    }
}