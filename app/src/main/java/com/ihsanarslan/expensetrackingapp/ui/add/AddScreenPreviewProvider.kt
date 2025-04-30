package com.ihsanarslan.expensetrackingapp.ui.add

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class AddScreenPreviewProvider : PreviewParameterProvider<AddContract.UiState> {
    override val values: Sequence<AddContract.UiState>
        get() = sequenceOf(
            AddContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            AddContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            AddContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}