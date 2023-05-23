package com.alextos.organize.presentation

import androidx.lifecycle.ViewModel

actual abstract class BaseViewModel: ViewModel() {
    actual abstract val title: String
}