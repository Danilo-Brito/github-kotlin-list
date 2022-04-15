package com.danilobrito.mainlist.data.repository

import android.content.Context
import com.danilobrito.mainlist.data.api.GithubAPI
import com.danilobrito.mainlist.data.dto.SearchResultDTO
import com.danilobrito.mainlist.di.retrofit.RetrofitInstance
import com.danilobrito.mainlist.domain.entity.bo.SearchResultBO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class GithubRepository(
    private val dispatcherProvider: Dispatchers,
    private val context: Context
) {

    fun repositoryByStar(): Flow<Result<Any?>> {
        return flow {
            try {
                emit(
                    Result.success(fetchRepository())
                )
            } catch (exception: Exception) {
                emit(
                    Result.failure<Exception>(exception)
                )
            }
        }.flowOn(dispatcherProvider.IO)
    }

    private suspend fun fetchRepository(): SearchResultBO? {
        return RetrofitInstance.githubService.getRepository("language:kotlin","stars", 1).body()?.toSearchResultBO()
    }
}