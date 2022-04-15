package com.danilobrito.mainlist.di.modules

import com.danilobrito.mainlist.data.repository.GithubRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

class RepositoryModules {

    fun provide() = listOf(
        repositoryByStar
    )

    private val repositoryByStar = module {
        single { GithubRepository(Dispatchers, get()) }
    }
}