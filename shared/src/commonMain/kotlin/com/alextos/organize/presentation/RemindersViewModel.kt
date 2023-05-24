package com.alextos.organize.presentation

import com.alextos.organize.data.RemindersRepository
import com.alextos.organize.domain.Reminder

class RemindersViewModel: BaseViewModel() {
    private val repository = RemindersRepository()

    internal val reminders: List<Reminder>
        get() = repository.reminders

    var onRemindersUpdated: ((List<Reminder>) -> Unit)? = null
        set(value) {
            field = value
            onRemindersUpdated?.invoke(reminders)
        }

    fun createReminder(title: String) {
        val trimmed = title.trim()
        if (trimmed.isNotEmpty()) {
            repository.createReminder(trimmed)
            onRemindersUpdated?.invoke(reminders)
        }
    }

    fun markReminder(id: String, isCompleted: Boolean) {
        repository.markReminder(id, isCompleted)
        onRemindersUpdated?.invoke(reminders)
    }

    override val title: String = "Reminders"
}