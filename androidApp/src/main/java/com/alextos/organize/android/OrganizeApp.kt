package com.alextos.organize.android

import android.app.Application
import com.alextos.organize.initKoin
import com.alextos.organize.presentation.AboutViewModel
import com.alextos.organize.presentation.RemindersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class OrganizeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            viewModelsModule = module {
                viewModel {
                    RemindersViewModel(get())
                }
                viewModel {
                    AboutViewModel(get())
                }
            }
        )
    }
}