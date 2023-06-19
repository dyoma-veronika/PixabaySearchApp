package com.example.pixabaysearchapp.presentation.ui.details_screen.components

import com.example.pixabaysearchapp.presentation.model.ImageViewData

data class ImageDetailState(
    val isLoading: Boolean = false,
    val image: ImageViewData? = null
)
