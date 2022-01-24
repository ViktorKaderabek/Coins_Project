package com.example.coins_project.Presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.coins_project.Presentation.theme.Coins_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Coins_ProjectTheme {

                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}
