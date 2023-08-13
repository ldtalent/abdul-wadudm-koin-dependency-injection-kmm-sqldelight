package com.example.di.di

import com.example.di.data.NotesRepository
import com.example.di.db.DatabaseHelper
import com.example.di.viewmodel.NotesViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
    val repositories = module {
        factory { NotesRepository(get()) }
    }

    val core = module {
        factory { DatabaseHelper(get()) }
    }

    val viewModels = module {
        factory { NotesViewModel(get()) }
    }
}

expect val platformModule: Module


fun initKoin(
    appModule: Module = module { },
    repositoriesModule: Module = Modules.repositories,
    viewModelsModule: Module = Modules.viewModels,
): KoinApplication = startKoin {
    modules(
        appModule,
        repositoriesModule,
        viewModelsModule,
        platformModule
    )
}