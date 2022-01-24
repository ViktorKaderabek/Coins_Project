package com.example.coins_project.Domain.Model

import com.example.coins_project.Data.Remote.Dto.TeamMember

data class CoinsDetail(
    val coinId : String,
    val name : String,
    val description : String,
    val symbol : String,
    val rank : Int,
    val isActive : Boolean,
    val team : List<TeamMember>
)