package com.nick.kotlintest101.helper

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringHelperUnitTest {
    @Test
    fun testHelloWorld() {
        assertThat(StringHelper.getHelloWorld()).isEqualTo("Hello World")
    }
}
