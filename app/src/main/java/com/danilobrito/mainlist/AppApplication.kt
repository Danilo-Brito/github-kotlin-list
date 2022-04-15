package com.danilobrito.mainlist

import android.app.Application
import com.danilobrito.mainlist.di.ModulesProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication: Application() {

    override fun onCreate() {
        val modules = ModulesProvider().provide()

        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(modules)
        }
    }
}