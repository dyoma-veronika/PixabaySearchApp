package com.example.pixabaysearchapp.domain.repository

import com.example.pixabaysearchapp.utils.Resource
import com.example.pixabaysearchapp.domain.model.ImageData

interface ImageRepository {

    suspend fun getImages(query: String): Resource<List<ImageData>>

    suspend fun getImageById(id: Int): ImageData
}
