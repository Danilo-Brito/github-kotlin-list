package com.danilobrito.mainlist.di.modules

import com.danilobrito.mainlist.domain.usecase.StarUseCase
import org.koin.dsl.module

class UseCaseModules {

    fun provide() = listOf(
        useCaseModule
    )

    private val useCaseModule = module {
        single { StarUseCase(get()) }
    }
}