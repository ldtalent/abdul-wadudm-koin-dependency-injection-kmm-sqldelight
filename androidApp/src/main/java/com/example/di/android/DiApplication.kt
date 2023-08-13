package com.example.di.android

import android.app.Application
import android.content.Context
import com.example.di.di.initKoin
import com.example.di.viewmodel.NotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class DiApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            appModule = module {
                single<Context> {
                    this@DiApplication
                }
            },
            viewModelsModule = module {
                viewModel {
                    NotesViewModel(get())
                }
            }
        )
    }
}