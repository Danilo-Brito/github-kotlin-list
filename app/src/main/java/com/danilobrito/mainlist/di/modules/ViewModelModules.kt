package com.danilobrito.mainlist.di.modules

import com.danilobrito.mainlist.ui.GithubListViewModel
import org.koin.dsl.module

class ViewModelModules {

    fun provide() = listOf(
        starViewModel
    )

    private val starViewModel = module {
        single { GithubListViewModel(get()) }
    }
}