package com.example.pixabaysearchapp.data.remote.model

data class ImageResponse(
    val hits: List<ImageDto>,
    val total: Int,
    val totalHits: Int
)
