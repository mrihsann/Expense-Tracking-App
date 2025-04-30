package com.ihsanarslan.expensetrackingapp.ui.auth

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
import com.ihsanarslan.expensetrackingapp.ui.auth.AuthContract.UiAction
import com.ihsanarslan.expensetrackingapp.ui.auth.AuthContract.UiEffect
import com.ihsanarslan.expensetrackingapp.ui.auth.AuthContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun AuthScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> AuthContent()
    }
}

@Composable
fun AuthContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Auth Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview(
    @PreviewParameter(AuthScreenPreviewProvider::class) uiState: UiState,
) {
    AuthScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}