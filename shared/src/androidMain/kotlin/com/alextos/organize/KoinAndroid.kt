package com.alextos.organize

import org.koin.dsl.module
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual val platformModule = module {
    single<Settings> {
        SharedPreferencesSettings(get())
    }
    single<SqlDriver> {
        AndroidSqliteDriver(OrganizeDb.Schema, get(), "OrganizeDb")
    }
}