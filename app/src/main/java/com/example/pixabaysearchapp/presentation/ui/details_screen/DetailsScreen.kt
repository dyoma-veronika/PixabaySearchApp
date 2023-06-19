package com.example.pixabaysearchapp.presentation.ui.details_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pixabaysearchapp.presentation.ui.details_screen.components.ImageDetail

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val state = viewModel.imageState.value
    state.image?.let { image ->
        ImageDetail(image = image, navigateBack)
    }
}
