package com.danilobrito.mainlist.data.api

import com.danilobrito.mainlist.data.dto.SearchResultDTO
import com.danilobrito.mainlist.util.ApiConstants.Companion.SEARCH_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPI {

    @GET(SEARCH_ENDPOINT)
    suspend fun getRepository(
        @Query("q") queryParams: String,
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int
    ): Response<SearchResultDTO>
}