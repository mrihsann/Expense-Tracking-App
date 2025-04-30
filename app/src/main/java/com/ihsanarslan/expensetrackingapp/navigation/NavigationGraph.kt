package com.ihsanarslan.expensetrackingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ihsanarslan.expensetrackingapp.navigation.Screen.Auth
import com.ihsanarslan.expensetrackingapp.navigation.Screen.Home
import com.ihsanarslan.expensetrackingapp.navigation.Screen.Detail
import com.ihsanarslan.expensetrackingapp.navigation.Screen.Settings
import com.ihsanarslan.expensetrackingapp.navigation.Screen.Tracking
import com.ihsanarslan.expensetrackingapp.navigation.Screen.Add
import com.ihsanarslan.expensetrackingapp.ui.auth.AuthScreen
import com.ihsanarslan.expensetrackingapp.ui.auth.AuthViewModel
import com.ihsanarslan.expensetrackingapp.ui.home.HomeScreen
import com.ihsanarslan.expensetrackingapp.ui.home.HomeViewModel
import com.ihsanarslan.expensetrackingapp.ui.detail.DetailScreen
import com.ihsanarslan.expensetrackingapp.ui.detail.DetailViewModel
import com.ihsanarslan.expensetrackingapp.ui.settings.SettingsScreen
import com.ihsanarslan.expensetrackingapp.ui.settings.SettingsViewModel
import com.ihsanarslan.expensetrackingapp.ui.tracking.TrackingScreen
import com.ihsanarslan.expensetrackingapp.ui.tracking.TrackingViewModel
import com.ihsanarslan.expensetrackingapp.ui.add.AddScreen
import com.ihsanarslan.expensetrackingapp.ui.add.AddViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Auth> {
            val viewModel: AuthViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            AuthScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Home> {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            HomeScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Detail> {
            val viewModel: DetailViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            DetailScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Settings> {
            val viewModel: SettingsViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            SettingsScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Tracking> {
            val viewModel: TrackingViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            TrackingScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Add> {
            val viewModel: AddViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            AddScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
    }
}