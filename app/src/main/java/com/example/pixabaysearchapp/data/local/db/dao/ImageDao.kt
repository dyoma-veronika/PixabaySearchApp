package com.example.pixabaysearchapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pixabaysearchapp.data.local.db.entity.ImageEntity

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<ImageEntity>)

    @Query("SELECT * FROM images")
    suspend fun getImages(): List<ImageEntity>

    @Query("SELECT * FROM images WHERE id = :id")
    suspend fun getImageById(id: Int): ImageEntity
}
