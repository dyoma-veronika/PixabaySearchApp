package com.example.pixabaysearchapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.pixabaysearchapp.navigation.NavGraph
import com.example.pixabaysearchapp.presentation.ui.theme.PixabaySearchAppTheme
import com.example.pixabaysearchapp.utils.NetworkConnection
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val networkConnection by lazy {
        NetworkConnection(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkConnection.registerConnection()
        setContent {
            PixabaySearchAppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    NavGraph(navController)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkConnection.unregisterConnection()
    }
}
