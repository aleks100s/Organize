package com.alextos.organize.data

import kotlin.test.Test
import kotlin.test.assertTrue

class RemindersRepositoryTest {
    // test function that tests the creation of a reminder in RemindersRepository
    @Test
    fun testCreateReminder() {
        val remindersRepository = RemindersRepository()
        remindersRepository.createReminder("Test Reminder")
        assertTrue(remindersRepository.reminders.isNotEmpty())
    }

    // test function that tests the marking of a reminder in RemindersRepository
    @Test
    fun testMarkReminder() {
        val remindersRepository = RemindersRepository()
        remindersRepository.createReminder("Test Reminder")
        val reminder = remindersRepository.reminders.first()
        remindersRepository.markReminder(reminder.id, true)
        assertTrue(remindersRepository.reminders.first().isCompleted)
    }
}