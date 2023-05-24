package com.alextos.organize.presentation

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class RemindersViewModelTest {
    private lateinit var viewModel: RemindersViewModel

    @BeforeTest
    fun setup() {
        viewModel = RemindersViewModel()
    }

    @Test
    fun testCreatingReminder() {
        val title = "Test reminder"
        viewModel.createReminder(title)
        val count = viewModel.reminders.count { it.title == title }
        assertTrue(count == 1, "Reminder was not created")
    }
}