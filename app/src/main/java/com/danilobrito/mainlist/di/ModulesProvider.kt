package com.danilobrito.mainlist.di

import com.danilobrito.mainlist.di.modules.*

class ModulesProvider {
    fun provide() = listOf(
        GithubAPIModules().provide(),
        RepositoryModules().provide(),
        ViewModelModules().provide(),
        DataSourceModules().provide()
    ).flatten()
}