package com.ihsanarslan.expensetrackingapp.ui.tracking

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
import com.ihsanarslan.expensetrackingapp.ui.tracking.TrackingContract.UiAction
import com.ihsanarslan.expensetrackingapp.ui.tracking.TrackingContract.UiEffect
import com.ihsanarslan.expensetrackingapp.ui.tracking.TrackingContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun TrackingScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> TrackingContent()
    }
}

@Composable
fun TrackingContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Tracking Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TrackingScreenPreview(
    @PreviewParameter(TrackingScreenPreviewProvider::class) uiState: UiState,
) {
    TrackingScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}