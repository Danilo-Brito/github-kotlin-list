package com.danilobrito.mainlist.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.danilobrito.mainlist.data.dto.ItemDTO
import com.danilobrito.mainlist.data.paging.GithubDataSource
import com.danilobrito.mainlist.di.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class GithubRepository(
    private val dispatcherProvider: Dispatchers,
) {

    fun getGithubRepository(language: String): Flow<PagingData<ItemDTO>> = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { GithubDataSource(language, RetrofitInstance.githubService, dispatcherProvider) }
    ).flow
}