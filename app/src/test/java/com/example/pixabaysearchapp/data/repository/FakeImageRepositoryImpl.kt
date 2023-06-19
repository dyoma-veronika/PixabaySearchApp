package com.example.pixabaysearchapp.data.repository

import com.example.pixabaysearchapp.domain.model.ImageData
import com.example.pixabaysearchapp.domain.repository.ImageRepository
import com.example.pixabaysearchapp.utils.Resource

class FakeImageRepositoryImpl : ImageRepository {
    override suspend fun getImages(query: String): Resource<List<ImageData>> {
        val imageList = listOf(
            ImageData(
                id = 1,
                previewURL = "url",
                largeImageURL = "largeUrl",
                user = "user",
                tags = listOf("tag1", "tag2", "tag3"),
                likes = 0,
                downloads = 0,
                comments = 0,
                query = "search"
            )
        )

        return Resource.Success(data = imageList)
    }


    override suspend fun getImageById(id: Int): ImageData =
        ImageData(
            1,
            "url",
            "largeUrl",
            "user",
            listOf("tag1", "tag2", "tag3"),
            0,
            0,
            0,
            "search"
        )
}
