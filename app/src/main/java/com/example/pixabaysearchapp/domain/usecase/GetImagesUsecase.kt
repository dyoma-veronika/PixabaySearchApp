package com.example.pixabaysearchapp.domain.usecase

import com.example.pixabaysearchapp.domain.model.ImageData
import com.example.pixabaysearchapp.domain.repository.ImageRepository
import com.example.pixabaysearchapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetImagesUsecase(private val imageRepository: ImageRepository) {
    operator fun invoke(query: String): Flow<Resource<List<ImageData>>> = flow {
        val data = imageRepository.getImages(query)
        emit(data)
    }.flowOn(Dispatchers.IO)
}
