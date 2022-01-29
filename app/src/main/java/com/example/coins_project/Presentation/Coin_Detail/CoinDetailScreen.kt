package com.example.coins_project.Presentation.Coin_Detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coins_project.Presentation.Coin_Detail.components.TeamListItem
import com.google.accompanist.flowlayout.FlowRow
import org.koin.androidx.compose.inject
import org.koin.core.component.KoinComponent


@Composable
fun CoinDetailScreen() {
    val viewModel by inject<CoinDetailVIewModel>()

    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coinsDetail?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            fontSize = 20.sp,
                            modifier = Modifier.weight(8f),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coin.description,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team members",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(coin.team) { teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    Divider()
                }
            }
        }
    }
}