package com.example.pixabaysearchapp.di

import android.content.Context
import androidx.room.Room
import com.example.pixabaysearchapp.data.local.db.ImagesDatabase
import com.example.pixabaysearchapp.data.local.db.dao.ImageDao
import com.example.pixabaysearchapp.data.remote.api.PixabayAPI
import com.example.pixabaysearchapp.data.repository.ImageRepositoryImpl
import com.example.pixabaysearchapp.domain.repository.ImageRepository
import com.example.pixabaysearchapp.domain.usecase.GetImageByIdUsecase
import com.example.pixabaysearchapp.domain.usecase.GetImagesUsecase
import com.example.pixabaysearchapp.utils.Constants.BASE_URL
import com.example.pixabaysearchapp.utils.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePixabayApi(): PixabayAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideImagesDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ImagesDatabase::class.java, DB_NAME).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideImageDao(
        database: ImagesDatabase
    ) = database.imageDao()


    @Singleton
    @Provides
    fun provideImageRepository(
        dao: ImageDao,
        api: PixabayAPI
    ): ImageRepository = ImageRepositoryImpl(dao, api)

    @Singleton
    @Provides
    fun provideGetImagesUsecase(
        repository: ImageRepository
    ): GetImagesUsecase = GetImagesUsecase(repository)

    @Singleton
    @Provides
    fun provideGetImageByIdUsecase(
        repository: ImageRepository
    ): GetImageByIdUsecase = GetImageByIdUsecase(repository)
}
