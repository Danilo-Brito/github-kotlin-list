package com.danilobrito.mainlist.di.modules

import com.danilobrito.mainlist.data.paging.GithubDataSource
import com.danilobrito.mainlist.data.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

class DataSourceModules {

    fun provide() = listOf(
        datasource
    )

    private val datasource = module {
        single { GithubDataSource(get(), get(), Dispatchers) }
    }
}