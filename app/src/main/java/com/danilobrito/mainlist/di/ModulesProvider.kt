package com.danilobrito.mainlist.di

import com.danilobrito.mainlist.di.modules.GithubAPIModules
import com.danilobrito.mainlist.di.modules.RepositoryModules
import com.danilobrito.mainlist.di.modules.UseCaseModules
import com.danilobrito.mainlist.di.modules.ViewModelModules

class ModulesProvider {
    fun provide() = listOf(
        GithubAPIModules().provide(),
        RepositoryModules().provide(),
        ViewModelModules().provide(),
        UseCaseModules().provide()
    ).flatten()
}