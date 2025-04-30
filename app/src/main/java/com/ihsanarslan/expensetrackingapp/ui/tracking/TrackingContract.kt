package com.ihsanarslan.expensetrackingapp.ui.tracking

object TrackingContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction

    sealed class UiEffect
}