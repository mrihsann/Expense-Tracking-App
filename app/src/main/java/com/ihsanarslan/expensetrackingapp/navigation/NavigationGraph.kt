package com.ihsanarslan.expensetrackingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ihsanarslan.expensetrackingapp.presentation.auth.AuthScreen
import com.ihsanarslan.expensetrackingapp.presentation.home.HomeScreen
import com.ihsanarslan.expensetrackingapp.presentation.settings.SettingsScreen
import com.ihsanarslan.expensetrackingapp.presentation.tracking.TrackingScreen
import com.ihsanarslan.expensetrackingapp.presentation.add.AddScreen
import com.ihsanarslan.expensetrackingapp.presentation.auth.LoginScreen
import com.ihsanarslan.expensetrackingapp.presentation.auth.RegisterScreen
import com.ihsanarslan.expensetrackingapp.presentation.list.ListScreen

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
        composable<Screen.Auth> {
            AuthScreen(navController)
        }
        composable<Screen.Home> {
            HomeScreen(navController)
        }
        composable<Screen.Settings> {
            SettingsScreen(navController)
        }
        composable<Screen.Tracking> {
            TrackingScreen()
        }
        composable<Screen.Add> {
            AddScreen(navController)
        }
        composable<Screen.Register> {
            RegisterScreen(navController)
        }
        composable<Screen.Login>{
            LoginScreen(navController)
        }
        composable<Screen.List>{
            ListScreen(navController)
        }
    }
}