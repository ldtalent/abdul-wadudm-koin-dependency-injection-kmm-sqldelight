package com.example.di.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.di.NoteDatabase
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module


object KoinIos {
    fun initialize(): KoinApplication = initKoin(
        appModule = module {
        }
    )
}

fun Koin.get(objCClass: ObjCClass): Any {
    val klass = getOriginalKotlinClass(objCClass)!!
    return get(klass, null, null)
}

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier) { parametersOf(parameter) }
}

actual val platformModule: Module = module {
    single<SqlDriver> {
        NativeSqliteDriver(NoteDatabase.Schema, "ReminderDb")
    }
}