package com.example.coins_project.Presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coins_project.Presentation.Coin_Detail.CoinDetailScreen
import com.example.coins_project.Presentation.Coin_List.CoinListScreen
import com.example.coins_project.Presentation.Coin_List.CoinListVIewModel
import com.example.coins_project.Presentation.theme.Coins_ProjectTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val viewModel by inject<CoinListVIewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Coins_ProjectTheme {
                Surface(color = MaterialTheme.colors.onBackground) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{kokot}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}



