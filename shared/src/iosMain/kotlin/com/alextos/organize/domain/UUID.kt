package com.alextos.organize.domain

import platform.Foundation.NSUUID

actual class UUID actual constructor() {
    private val value = NSUUID()

    actual override fun toString() = value.UUIDString()
}