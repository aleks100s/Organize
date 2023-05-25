package com.alextos.organize

import com.alextos.organize.data.RemindersRepository
import com.alextos.organize.presentation.AboutViewModel
import com.alextos.organize.presentation.RemindersViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
    val core = module {
        // single instance
        single { Platform() }
    }
    val repositories = module {
        // gives new instance each time
        factory { RemindersRepository() }
    }
    val viewModels = module {
        // gives new instance each time
        factory { RemindersViewModel(get()) }
        factory { AboutViewModel(get()) }
    }
}

fun initKoin(
    appModule: Module = module { },
    coreModule: Module = Modules.core,
    repositoriesModule: Module = Modules.repositories,
    viewModelsModule: Module = Modules.viewModels
): KoinApplication = startKoin {
    modules(
        appModule,
        coreModule,
        repositoriesModule,
        viewModelsModule
    )
}