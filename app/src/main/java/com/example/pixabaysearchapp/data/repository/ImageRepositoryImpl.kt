package com.example.pixabaysearchapp.data.repository

import com.example.pixabaysearchapp.data.local.db.dao.ImageDao
import com.example.pixabaysearchapp.data.local.db.mapper.toImageData
import com.example.pixabaysearchapp.data.local.db.mapper.toImageEntity
import com.example.pixabaysearchapp.data.remote.api.PixabayAPI
import com.example.pixabaysearchapp.data.remote.mapper.toImageData
import com.example.pixabaysearchapp.domain.model.ImageData
import com.example.pixabaysearchapp.domain.repository.ImageRepository
import com.example.pixabaysearchapp.utils.NetworkConnection
import com.example.pixabaysearchapp.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageDao: ImageDao,
    private val api: PixabayAPI
) : ImageRepository {

    override suspend fun getImages(query: String): Resource<List<ImageData>> {
        return try {
            if (NetworkConnection.isConnected()) {
                val images = api.getImages(query).toImageData(query)
                val localImages = images.map {
                    it.toImageEntity()
                }
                imageDao.insertImages(localImages)
                Resource.Success(images)
            } else {
                val images = imageDao.getImages()
                    .map {
                        it.toImageData()
                    }.filter {
                        it.query.equals(query, ignoreCase = true)
                    }
                if (images.isEmpty()) {
                    Resource.Error("No internet")
                } else {
                    Resource.Success(images)
                }
            }
        } catch (e: HttpException) {
            val errorMessage = when (e.code()) {
                404 -> "Images not found"
                500 -> "Server error occurred"
                else -> e.localizedMessage ?: "Error occurred"
            }
            Resource.Error(errorMessage)
        } catch (e: IOException) {
            Resource.Error("Error occurred while retrieving images")
        }
    }

    override suspend fun getImageById(id: Int): ImageData =
        imageDao.getImageById(id).toImageData()
}
