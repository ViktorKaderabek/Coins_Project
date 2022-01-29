package com.example.coins_project.Presentation.Coin_List.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coins_project.Domain.Model.Coins

@Composable
fun CoinListItem(
    coin: Coins,
    onItemClick: (Coins) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable { onItemClick(coin) }
            .padding(10.dp)
    ) {
        Card(

            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                                startY = 5f
                            )
                        )
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onItemClick(coin) }
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = TextStyle(color = Color.White, fontSize = 14.sp),
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Type : (${coin.type})",
                            style = TextStyle(color = Color.White, fontSize = 10.sp),
                            overflow = TextOverflow.Ellipsis
                        )

                        Text(
                            text = if (coin.is_active) "active" else "not active",
                            color = if (coin.is_active) Color.Green else Color.Red,
                            fontStyle = Italic,
                            textAlign = TextAlign.End,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 10.sp
                        )
                    }
                }
            }

        }
    }
}
