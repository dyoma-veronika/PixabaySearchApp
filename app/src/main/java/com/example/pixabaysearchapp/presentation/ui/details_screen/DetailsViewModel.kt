package com.example.pixabaysearchapp.presentation.ui.details_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixabaysearchapp.domain.usecase.GetImageByIdUsecase
import com.example.pixabaysearchapp.presentation.mapper.toImageViewData
import com.example.pixabaysearchapp.presentation.ui.details_screen.components.ImageDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getImageByIdUseCase: GetImageByIdUsecase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _imageState = mutableStateOf(ImageDetailState())
    val imageState: State<ImageDetailState> = _imageState

    init {
        savedStateHandle.get<Int>("id")?.let { id ->
            getImageById(id)
        }
    }

    fun getImageById(id: Int) {
        _imageState.value = ImageDetailState(isLoading = true)
        getImageByIdUseCase(id).onEach { image ->
            _imageState.value = ImageDetailState(image = image.toImageViewData())
        }.launchIn(viewModelScope)
    }
}
