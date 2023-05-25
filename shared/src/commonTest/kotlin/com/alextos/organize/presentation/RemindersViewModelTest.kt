package com.alextos.organize.presentation

import com.alextos.organize.data.RemindersRepository
import com.alextos.organize.initKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class RemindersViewModelTest: KoinTest {
    private val viewModel: RemindersViewModel by inject()

    @BeforeTest
    fun setup() {
        initKoin()
    }

    @Test
    fun testCreatingReminder() {
        val title = "Test reminder"
        viewModel.createReminder(title)
        val count = viewModel.reminders.count { it.title == title }
        assertTrue(count == 1, "Reminder was not created")
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }
}