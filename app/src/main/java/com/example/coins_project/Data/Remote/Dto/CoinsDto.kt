package com.example.coins_project.Data.Remote.Dto

import com.example.coins_project.Domain.Model.Coins

data class CoinsDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinsDto.toCoins() : Coins {
    return Coins(
        id = id,
        is_active = is_active,
        name = name,
        symbol = symbol
    )
}