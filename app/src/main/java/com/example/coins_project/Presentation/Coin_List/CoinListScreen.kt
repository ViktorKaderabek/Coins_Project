package com.example.coins_project.Presentation.Coin_List

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coins_project.Presentation.Coin_List.CoinListScreen.Companion.coinId
import com.example.coins_project.Presentation.Coin_List.components.CoinListItem
import com.example.coins_project.Presentation.Screen
import org.koin.androidx.compose.inject

class CoinListScreen{
    companion object{
    var coinId : String? = null
    }
}

@Composable
fun CoinListScreen(
    navController: NavController,
) {
    val viewModel by inject<CoinListVIewModel>()
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.coinsList) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route + "/id")
                        coinId = coin.id
                        Log.e("message", (coin.name +   coin.symbol +  coin.id).toString())
                    }
                )
            }
        }
    }
}