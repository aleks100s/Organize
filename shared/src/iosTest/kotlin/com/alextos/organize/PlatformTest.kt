package com.alextos.organize

import kotlin.test.Test
import kotlin.test.assertTrue

actual class PlatformTest {
    private val platform = Platform()

    @Test
    actual fun testOperatingSystemName() {
        assertTrue(
            actual = platform.osName.equals("iOS", ignoreCase = true)
                    || platform.osName.equals("iPadOS", ignoreCase = true),
            message = "Platform should be iOS or iPadOS"
        )
    }
}