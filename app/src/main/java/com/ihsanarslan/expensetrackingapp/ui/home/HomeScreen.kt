package com.ihsanarslan.expensetrackingapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.ihsanarslan.expensetrackingapp.navigation.Screen
import com.ihsanarslan.expensetrackingapp.ui.components.EmptyScreen
import com.ihsanarslan.expensetrackingapp.ui.components.LoadingBar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun HomeScreen(
    navController : NavController
) {

    val viewModel = hiltViewModel<HomeViewModel>()
    val isUserAuthenticated = viewModel.isAuthenticated.collectAsStateWithLifecycle()

    LaunchedEffect(isUserAuthenticated.value) {
        if (!isUserAuthenticated.value){
            navController.navigate(Screen.Login)
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Home", fontSize = 24.sp)
        Button(
            onClick = {
                viewModel.signOut()
            }
        ) {
            Text(text = "Sign Out")
        }
    }

}
