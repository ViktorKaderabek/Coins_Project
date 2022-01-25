package com.example.coins_project.Domain.Model

data class Coins(
    val id : String,
    val rank : Int,
    val is_active: Boolean,
    val name: String,
    val symbol: String,
    val type : String
)
