package com.danilobrito.mainlist.di.modules

import com.danilobrito.mainlist.data.api.GithubAPI
import org.koin.dsl.module

class GithubAPIModules {

    fun provide() = listOf(
        apiModule
    )

    private val apiModule = module {
        single { GithubAPI::class }
    }
}