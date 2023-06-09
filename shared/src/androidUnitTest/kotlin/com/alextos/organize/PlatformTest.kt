package com.alextos.organize

import org.junit.Test
import kotlin.test.assertEquals

actual class PlatformTest {
    private val platform = Platform()

    @Test
    actual fun testOperatingSystemName() {
        assertEquals(
            expected = "Android",
            actual = platform.osName,
            message = "Platform should be Android"
        )
    }
}