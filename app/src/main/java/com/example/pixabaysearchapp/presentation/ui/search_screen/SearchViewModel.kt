package com.example.pixabaysearchapp.presentation.ui.search_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixabaysearchapp.domain.usecase.GetImagesUsecase
import com.example.pixabaysearchapp.presentation.mapper.toImageViewData
import com.example.pixabaysearchapp.presentation.ui.search_screen.components.ImageSearchState
import com.example.pixabaysearchapp.utils.Constants
import com.example.pixabaysearchapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getImagesUsecase: GetImagesUsecase
) : ViewModel() {

    val searchQuery = mutableStateOf(Constants.DEFAULT_SEARCH_QUERY)

    private val _imagesList = mutableStateOf(ImageSearchState())
    val imagesList: State<ImageSearchState> = _imagesList

    init {
        getImages(searchQuery.value)
    }

    fun getImages(query: String) {
        searchQuery.value = query
        getImagesUsecase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val data = result.data?.map {
                        it.toImageViewData()
                    }
                    _imagesList.value = ImageSearchState(images = data ?: emptyList())
                }

                is Resource.Loading -> {
                    _imagesList.value = ImageSearchState(isLoading = true)
                }

                is Resource.Error -> {
                    _imagesList.value =
                        ImageSearchState(error = result.message ?: "Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}
