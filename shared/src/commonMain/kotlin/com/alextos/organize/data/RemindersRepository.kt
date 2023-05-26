package com.alextos.organize.data

import com.alextos.organize.db.ReminderDb
import com.alextos.organize.domain.Reminder
import com.alextos.organize.domain.UUID

class RemindersRepository(
    private val databaseHelper: DatabaseHelper
) {
    private val _reminders: MutableList<Reminder> = mutableListOf()
    val reminders: List<Reminder>
        get() = databaseHelper.fetchAllItems().map(ReminderDb::map)

    fun createReminder(title: String) {
        databaseHelper.insertReminder(UUID().toString(), title)
    }

    fun markReminder(id: String, isCompleted: Boolean) {
        databaseHelper.updateIsCompleted(id, isCompleted)
    }
}

fun ReminderDb.map() = Reminder(
    id = this.id,
    title = this.title,
    isCompleted = this.isCompleted(),
)