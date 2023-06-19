package com.example.pixabaysearchapp.presentation.ui.details_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pixabaysearchapp.R
import com.example.pixabaysearchapp.presentation.ui.components.IconText
import com.example.pixabaysearchapp.presentation.ui.components.defaultPadding
import com.example.pixabaysearchapp.presentation.ui.components.defaultSpacerWidth

@Composable
fun ImageStats(
    likesCount: Int,
    commentsCount: Int,
    downloadsCount: Int,
){
    Row(
        modifier = Modifier
            .defaultPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        IconText(
            text = likesCount.toString(),
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_like,
            contentDescription = "Likes"
        )

        Spacer(modifier = Modifier.defaultSpacerWidth())

        IconText(
            text = commentsCount.toString(),
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_comment,
            contentDescription = "Comments"
        )


        Spacer(modifier = Modifier.defaultSpacerWidth())

        IconText(
            text = downloadsCount.toString(),
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_download,
            contentDescription = "Downloads"
        )
    }
}
