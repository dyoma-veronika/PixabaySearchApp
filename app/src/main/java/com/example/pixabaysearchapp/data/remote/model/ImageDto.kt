package com.example.pixabaysearchapp.data.remote.model

data class ImageDto(
    val id: Int,
    val comments: Int?,
    val downloads: Int?,
    val likes: Int?,
    val previewURL: String?,
    val largeImageURL: String?,
    val tags: String?,
    val user: String?
)
