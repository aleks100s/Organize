package com.alextos.organize.data

import com.alextos.organize.OrganizeDb
import com.alextos.organize.db.ReminderDb
import com.squareup.sqldelight.db.SqlDriver

class DatabaseHelper(
    sqlDriver: SqlDriver
) {
    private val dbRef: OrganizeDb = OrganizeDb(sqlDriver)

    fun  fetchAllItems(): List<ReminderDb> {
        return dbRef.tableQueries.selectAll().executeAsList()
    }

    fun insertReminder(id: String, title: String) {
        dbRef.tableQueries.insertReminder(id, title)
    }

    fun updateIsCompleted(id: String, isCompleted: Boolean) {
        dbRef.tableQueries.updateIsCompleted(if (isCompleted) 1 else 0, id)
    }
}

fun ReminderDb.isCompleted(): Boolean {
    return isCompleted != 0L
}