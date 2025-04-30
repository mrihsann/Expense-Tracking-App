package com.ihsanarslan.expensetrackingapp.ui.auth

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class AuthScreenPreviewProvider : PreviewParameterProvider<AuthContract.UiState> {
    override val values: Sequence<AuthContract.UiState>
        get() = sequenceOf(
            AuthContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            AuthContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            AuthContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}