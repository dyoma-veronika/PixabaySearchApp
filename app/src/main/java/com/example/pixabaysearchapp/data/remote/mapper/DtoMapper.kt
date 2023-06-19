package com.example.pixabaysearchapp.data.remote.mapper

import com.example.pixabaysearchapp.data.remote.model.ImageResponse
import com.example.pixabaysearchapp.data.remote.model.ImageDto
import com.example.pixabaysearchapp.domain.model.ImageData
import com.example.pixabaysearchapp.utils.getAsList

fun ImageDto.toImageData(query: String) = ImageData(

    id = id,
    previewURL = previewURL ?: "",
    largeImageURL = largeImageURL ?: "",
    tags = tags?.getAsList() ?: emptyList(),
    user = user ?: "",
    likes = likes ?: 0,
    downloads = downloads ?: 0,
    comments = comments ?: 0,
    query = query
)

fun ImageResponse.toImageData(query: String): List<ImageData> {
    return hits.map { it.toImageData(query) }
}

fun ImageData.toImageDto() = ImageDto(
    id = id,
    previewURL = previewURL,
    largeImageURL = largeImageURL,
    tags = tags.joinToString(separator = ","),
    user = user,
    likes = likes,
    downloads = downloads,
    comments = comments
)
