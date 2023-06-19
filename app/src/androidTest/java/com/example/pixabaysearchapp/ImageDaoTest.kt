package com.example.pixabaysearchapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pixabaysearchapp.data.local.db.ImagesDatabase
import com.example.pixabaysearchapp.data.local.db.dao.ImageDao
import com.example.pixabaysearchapp.data.local.db.entity.ImageEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageDaoTest {

    private lateinit var imageDao: ImageDao
    private lateinit var db: ImagesDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ImagesDatabase::class.java
        ).build()
        imageDao = db.imageDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun testInsertAndGetImages() = runBlocking {
        val image = ImageEntity(
            1,
            "url",
            "largeUrl",
            "user",
            "tag1, tag2, tag3",
            0,
            0,
            0,
            "search"
        )
        val images = listOf(image)
        imageDao.insertImages(images)
        val retrievedImages = imageDao.getImages()
        assert(images == retrievedImages)
    }

    @Test
    fun testGetImageById() = runBlocking {
        val image = ImageEntity(
            1,
            "url",
            "largeUrl",
            "user",
            "tag1, tag2, tag3",
            0,
            0,
            0,
            "search"
        )
        imageDao.insertImages(listOf(image))
        val retrievedImage = imageDao.getImageById(1)
        assert(image == retrievedImage)
    }
}
