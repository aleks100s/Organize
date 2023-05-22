package com.alextos.organize.android.ui.root

sealed class Screen(val route: String) {
    object Reminders: Screen("reminders")
    object AboutDevice: Screen("about-device")
}
