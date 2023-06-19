package com.example.pixabaysearchapp.navigation

sealed class Screen(val route: String) {
    object SearchScreen : Screen("SearchScreen")
    object ImageDetailScreen : Screen("ImageDetailScreen") {
        const val routeWithArgument = "ImageDetailScreen/{id}"
        const val arg = "id"
    }
}
