package com.example.pixabaysearchapp.presentation.ui.search_screen

import com.example.pixabaysearchapp.MainCoroutineRule
import com.example.pixabaysearchapp.data.repository.FakeImageRepositoryImpl
import com.example.pixabaysearchapp.domain.usecase.GetImagesUsecase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class SearchViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: SearchViewModel
    private val getImagesUsecase = GetImagesUsecase(FakeImageRepositoryImpl())

    @Before
    fun setup() {
        viewModel = SearchViewModel(getImagesUsecase)
    }

    @Test
    fun `image list is not empty` () = runBlockingTest {
        val query = "test"
        viewModel.getImages(query)

        mainCoroutineRule.advanceUntilIdle()
        delay(1000)

        val imageList = viewModel.imagesList.value.images

        assertThat(imageList).isNotEmpty()
    }
}
