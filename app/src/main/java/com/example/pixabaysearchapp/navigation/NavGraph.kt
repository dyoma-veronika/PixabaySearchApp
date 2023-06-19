package com.example.pixabaysearchapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pixabaysearchapp.presentation.ui.details_screen.DetailsScreen
import com.example.pixabaysearchapp.presentation.ui.search_screen.SearchScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SearchScreen.route) {
        composable(Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }

        composable(
            route = Screen.ImageDetailScreen.routeWithArgument,
            arguments = listOf(
                navArgument(Screen.ImageDetailScreen.arg) {
                    type = NavType.IntType
                }
            )
        ) {
            DetailsScreen(navigateBack = {
                navController.popBackStack()
            })
        }
    }
}
