package com.alextos.organize

import com.russhwolf.settings.Settings
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults
import com.russhwolf.settings.NSUserDefaultsSettings
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual val platformModule = module {
    single<SqlDriver> {
        NativeSqliteDriver(OrganizeDb.Schema, "OrganizeDb")
    }
}

object KoinIOS {
    fun initialize(
        userDefaults: NSUserDefaults
    ): KoinApplication = initKoin(
        appModule = module {
            single<Settings> {
                NSUserDefaultsSettings(userDefaults)
            }
        }
    )
}

fun Koin.get(objCClass: ObjCClass): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, null, null)
}

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier) { parametersOf(parameter) }
}