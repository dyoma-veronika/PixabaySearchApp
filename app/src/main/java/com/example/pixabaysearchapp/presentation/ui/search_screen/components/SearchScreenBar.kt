package com.example.pixabaysearchapp.presentation.ui.search_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.pixabaysearchapp.presentation.ui.components.AppCard
import com.example.pixabaysearchapp.presentation.ui.components.AppText
import com.example.pixabaysearchapp.presentation.ui.components.defaultPadding
import com.example.pixabaysearchapp.presentation.ui.components.defaultScreenPadding
import com.example.pixabaysearchapp.presentation.ui.components.defaultSpacerWidth

@Composable
fun SearchScreenBar(
    defaultText: String? = null,
    hint: String = "Search for images like \"fruits\"",
    onSearch: (String) -> Unit
) {

    val defaultSearchTerm = defaultText ?: ""
    val text = remember {
        mutableStateOf(defaultSearchTerm)
    }

    var isHintDisplayed by remember {
        mutableStateOf(text.value == "" && hint != "")
    }

    AppCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .defaultScreenPadding()
    ) {
        Row(
            modifier = Modifier
                .defaultPadding()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = rememberVectorPainter(Icons.Outlined.Search),
                contentDescription = "Search by keywords",
                modifier = Modifier.padding(
                    start = 5.dp
                )
            )

            Spacer(modifier = Modifier.defaultSpacerWidth())

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BasicTextField(
                    value = text.value,
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    onValueChange = {
                        text.value = it
                        isHintDisplayed = it.trim().isEmpty()
                        onSearch(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()

                )
                if (isHintDisplayed) {
                    AppText(
                        text = hint,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
