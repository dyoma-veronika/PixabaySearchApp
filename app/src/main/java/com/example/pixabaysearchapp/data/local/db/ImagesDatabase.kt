package com.example.pixabaysearchapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pixabaysearchapp.data.local.db.dao.ImageDao
import com.example.pixabaysearchapp.data.local.db.entity.ImageEntity

@Database(
    entities = [ImageEntity::class],
    version = 2
)
abstract class ImagesDatabase : RoomDatabase() {

    abstract fun imageDao(): ImageDao
}
