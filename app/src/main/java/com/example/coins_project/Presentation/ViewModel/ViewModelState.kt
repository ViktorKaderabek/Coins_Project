package com.example.coins_project.Presentation.ViewModel

import com.example.coins_project.Domain.Model.Coins

data class ViewModelState(
    val isLoading : Boolean = false,
    val coinsList : List<Coins> = emptyList(),
    val error : String? = null
)