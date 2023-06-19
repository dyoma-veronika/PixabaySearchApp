package com.example.pixabaysearchapp.domain.usecase

import com.example.pixabaysearchapp.domain.model.ImageData
import com.example.pixabaysearchapp.domain.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetImageByIdUsecase(private val imageRepository: ImageRepository) {
    operator fun invoke(id: Int): Flow<ImageData> = flow {
        val image = imageRepository.getImageById(id)
        emit(image)
    }.flowOn(Dispatchers.IO)
}
