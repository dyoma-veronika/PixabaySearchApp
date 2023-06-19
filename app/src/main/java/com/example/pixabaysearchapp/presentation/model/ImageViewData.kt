package com.example.pixabaysearchapp.presentation.model

data class ImageViewData(
    val id: Int,
    val previewURL: String,
    val largeImageURL: String,
    val user: String,
    val tags: List<String>,
    val likes: Int,
    val downloads: Int,
    val comments: Int,
    val query: String
)
