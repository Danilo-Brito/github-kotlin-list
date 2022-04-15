package com.danilobrito.mainlist.di

import com.danilobrito.mainlist.data.api.GithubAPI
import com.danilobrito.mainlist.util.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val githubService by lazy {
        retrofit.create(GithubAPI::class.java)
    }
}