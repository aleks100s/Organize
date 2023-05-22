package com.alextos.organize

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform