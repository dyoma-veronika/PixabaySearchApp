package com.example.pixabaysearchapp.presentation.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    elevation: CardElevation = CardDefaults.cardElevation(3.dp),
    colors: CardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface
    ),
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        elevation = elevation,
        colors = colors
    ) {
        content()
    }
}
