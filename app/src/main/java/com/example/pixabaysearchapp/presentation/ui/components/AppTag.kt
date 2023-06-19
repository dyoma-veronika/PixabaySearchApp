package com.example.pixabaysearchapp.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun AppTag(
    tag: String
) {
    Box {
        Text(
            text = "#$tag",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 12.sp,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
