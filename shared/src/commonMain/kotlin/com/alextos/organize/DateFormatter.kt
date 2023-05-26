package com.alextos.organize

expect object DateFormatter {
    fun formatEpoch(epoch: Long): String
}