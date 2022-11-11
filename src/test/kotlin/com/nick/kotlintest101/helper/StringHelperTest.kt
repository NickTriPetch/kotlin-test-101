package com.nick.kotlintest101.helper

import com.nick.kotlintest101.IntegrationTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@IntegrationTest
class StringHelperTest {
    @Test
    fun testHelloWorld() {
        assertThat(StringHelper.getHelloWorld()).isEqualTo("Hello World")
    }
}
