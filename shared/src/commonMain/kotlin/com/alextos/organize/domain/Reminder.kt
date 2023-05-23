package com.alextos.organize.domain

data class Reminder(
    val id: String,
    val title: String,
    val isCompleted: Boolean = false
)