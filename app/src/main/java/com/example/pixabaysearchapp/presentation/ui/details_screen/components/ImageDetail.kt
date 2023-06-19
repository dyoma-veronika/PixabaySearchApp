package com.example.pixabaysearchapp.presentation.ui.details_screen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pixabaysearchapp.presentation.model.ImageViewData
import com.example.pixabaysearchapp.presentation.ui.components.AppImage
import com.example.pixabaysearchapp.presentation.ui.components.AppTag
import com.example.pixabaysearchapp.presentation.ui.components.AppText
import com.example.pixabaysearchapp.presentation.ui.components.defaultPadding
import com.example.pixabaysearchapp.presentation.ui.components.defaultSpacerHeight
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ImageDetail(
    image: ImageViewData,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            DetailsTopBar(navigateBack)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(290.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppImage(
                        imageUrl = image.largeImageURL,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )

                }
            }

            Spacer(modifier = Modifier.defaultSpacerHeight())

            ImageStats(
                image.likes,
                image.comments,
                image.downloads
            )

            Spacer(modifier = Modifier.defaultSpacerHeight())

            Row(
                modifier = Modifier
                    .defaultPadding()
                    .wrapContentHeight()
            ) {

                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            FlowRow(
                                mainAxisSpacing = 10.dp,
                                crossAxisSpacing = 10.dp,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                image.tags.forEach { tag ->
                                    AppTag(tag = tag)
                                }
                            }

                            Spacer(modifier = Modifier.defaultSpacerHeight())

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AppText(
                                    text = "@",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Normal,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                AppText(
                                    text = image.user,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )

                            }

                        }
                    }
                }
            }
        }
    }
}
