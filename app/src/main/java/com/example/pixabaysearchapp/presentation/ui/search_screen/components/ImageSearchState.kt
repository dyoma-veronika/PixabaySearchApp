package com.example.pixabaysearchapp.presentation.ui.search_screen.components

import com.example.pixabaysearchapp.presentation.model.ImageViewData

data class ImageSearchState(
    val isLoading: Boolean = false,
    val images: List<ImageViewData> = emptyList(),
    val error: String? = null
)
