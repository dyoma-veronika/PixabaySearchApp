package com.example.pixabaysearchapp.presentation.ui.search_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.pixabaysearchapp.R
import com.example.pixabaysearchapp.navigation.Screen
import com.example.pixabaysearchapp.presentation.ui.components.AppAlertDialog
import com.example.pixabaysearchapp.presentation.ui.components.AppText
import com.example.pixabaysearchapp.presentation.ui.components.defaultPadding
import com.example.pixabaysearchapp.presentation.ui.components.defaultSpacerHeight
import com.example.pixabaysearchapp.presentation.model.ImageViewData
import com.example.pixabaysearchapp.presentation.ui.search_screen.components.ImageListItem
import com.example.pixabaysearchapp.presentation.ui.search_screen.components.SearchScreenBar

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val state = searchViewModel.imagesList.value
    val query = searchViewModel.searchQuery.value
    val dialogState = remember {
        mutableStateOf(false)
    }

    val selectedItem = remember {
        mutableStateOf<ImageViewData?>(null)
    }

    if (dialogState.value) {
        AppAlertDialog(
            onDismissRequest = {
                dialogState.value = false
            },
            title = stringResource(R.string.confirm_action),
            text = stringResource(R.string.proceed_view_image_detail),
            confirmText = stringResource(R.string.yes),
            dismissText = stringResource(R.string.no),
            onConfirmClicked = {
                dialogState.value = false
                selectedItem.value?.let { item ->
                    navController.navigate(
                        Screen.ImageDetailScreen.route + "/${item.id}"
                    )
                }
            },
            onDismissClicked = {
                dialogState.value = false
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        SearchScreenBar(
            defaultText = query,
            onSearch = {
                searchViewModel.getImages(
                    query = it
                )
            }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 8.dp,
                    vertical = 2.dp
                )
        ) {

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            if (state.error != null) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .defaultPadding()
                ) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_dialog_alert),
                        contentDescription = "No Internet"
                    )

                    Spacer(modifier = Modifier.defaultSpacerHeight())

                    AppText(
                        text = state.error,
                        color = Color.Gray
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(state.images.size) { index ->
                    ImageListItem(
                        image = state.images[index],
                        onItemClick = { item ->
                            dialogState.value = true
                            selectedItem.value = item
                        }
                    )
                }
            }
        }
    }
}
