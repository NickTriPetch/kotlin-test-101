package com.nick.kotlintest101

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@UnitTest
class ExampleUnitTest {

    @Test
    fun `should be true when it is true`() {
        assertThat(true).isTrue()
    }
}
