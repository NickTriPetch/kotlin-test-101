package com.nick.kotlintest101

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ServerUnitTest {
    @Test
    fun `should be true when it true`() {
        assertThat(true).isTrue()
    }
}
