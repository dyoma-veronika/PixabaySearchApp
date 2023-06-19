package com.example.pixabaysearchapp.data.remote.api

import com.example.pixabaysearchapp.BuildConfig
import com.example.pixabaysearchapp.data.remote.model.ImageResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {

    @GET("/api/")
    suspend fun getImages(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): ImageResponse
}
