package com.ihsanarslan.expensetrackingapp.ui.add

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.ihsanarslan.expensetrackingapp.ui.components.EmptyScreen
import com.ihsanarslan.expensetrackingapp.ui.components.LoadingBar
import com.ihsanarslan.expensetrackingapp.ui.add.AddContract.UiAction
import com.ihsanarslan.expensetrackingapp.ui.add.AddContract.UiEffect
import com.ihsanarslan.expensetrackingapp.ui.add.AddContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun AddScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> AddContent()
    }
}

@Composable
fun AddContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Add Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview(
    @PreviewParameter(AddScreenPreviewProvider::class) uiState: UiState,
) {
    AddScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}