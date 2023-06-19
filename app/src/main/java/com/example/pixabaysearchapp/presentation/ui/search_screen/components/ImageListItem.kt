package com.example.pixabaysearchapp.presentation.ui.search_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.example.pixabaysearchapp.presentation.ui.components.AppCard
import com.example.pixabaysearchapp.presentation.ui.components.AppImage
import com.example.pixabaysearchapp.presentation.ui.components.AppTag
import com.example.pixabaysearchapp.presentation.ui.components.AppText
import com.example.pixabaysearchapp.presentation.ui.components.defaultPadding
import com.example.pixabaysearchapp.presentation.ui.components.defaultSpacerHeight
import com.example.pixabaysearchapp.presentation.ui.components.horizontalPadding
import com.example.pixabaysearchapp.presentation.ui.components.roundedCornerShape
import com.example.pixabaysearchapp.presentation.model.ImageViewData

@Composable
fun ImageListItem(
    image: ImageViewData,
    onItemClick: (ImageViewData) -> Unit
) {

    AppCard(
        modifier = Modifier
            .defaultPadding()
            .width(200.dp)
            .height(270.dp)
            .clickable {
                onItemClick(image)
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentAlignment = Alignment.Center
            ) {
                AppImage(
                    imageUrl = image.largeImageURL,
                    contentDescription = null,
                    modifier = Modifier.roundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 5.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
            }

            Column(
                modifier = Modifier.horizontalPadding()
            ) {

                Spacer(modifier = Modifier.defaultSpacerHeight())

                AppText(
                    text = "@${image.user}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.defaultSpacerHeight())

                FlowRow(
                    mainAxisSpacing = 4.dp,
                    crossAxisSpacing = 4.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    image.tags.forEach { tag ->
                        AppTag(tag = tag)
                    }
                }
            }
        }
    }
}
