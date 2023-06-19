package com.example.pixabaysearchapp.presentation.mapper

import com.example.pixabaysearchapp.domain.model.ImageData
import com.example.pixabaysearchapp.presentation.model.ImageViewData

fun ImageData.toImageViewData() = ImageViewData(
    id, previewURL, largeImageURL, user, tags, likes, downloads, comments, query
)

fun ImageViewData.toImageData() = ImageData(
    id, previewURL, largeImageURL, user, tags, likes, downloads, comments, query
)
