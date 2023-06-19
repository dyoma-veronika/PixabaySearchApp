package com.example.pixabaysearchapp.data.local.db.mapper

import com.example.pixabaysearchapp.data.local.db.entity.ImageEntity
import com.example.pixabaysearchapp.domain.model.ImageData
import com.example.pixabaysearchapp.utils.getAsList

fun ImageEntity.toImageData() = ImageData(
    id = id,
    previewURL = previewURL,
    largeImageURL = largeImageURL,
    tags = tags.getAsList(),
    user = user,
    likes = likes,
    downloads = downloads,
    comments = comments,
    query = query
)

fun ImageData.toImageEntity() = ImageEntity(
    id = id,
    previewURL = previewURL,
    largeImageURL = largeImageURL,
    tags = tags.joinToString(separator = ","),
    user = user,
    likes = likes,
    downloads = downloads,
    comments = comments,
    query = query
)
