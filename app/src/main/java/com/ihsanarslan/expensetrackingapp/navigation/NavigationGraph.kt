package com.ihsanarslan.expensetrackingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ihsanarslan.expensetrackingapp.ui.auth.AuthScreen
import com.ihsanarslan.expensetrackingapp.ui.home.HomeScreen
import com.ihsanarslan.expensetrackingapp.ui.detail.DetailScreen
import com.ihsanarslan.expensetrackingapp.ui.settings.SettingsScreen
import com.ihsanarslan.expensetrackingapp.ui.tracking.TrackingScreen
import com.ihsanarslan.expensetrackingapp.ui.add.AddScreen
import com.ihsanarslan.expensetrackingapp.ui.auth.LoginScreen
import com.ihsanarslan.expensetrackingapp.ui.auth.RegisterScreen
import com.ihsanarslan.expensetrackingapp.ui.list.ListScreen

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
        composable<Screen.Detail> {
            DetailScreen(navController)
        }
        composable<Screen.Settings> {
            SettingsScreen(navController)
        }
        composable<Screen.Tracking> {
            TrackingScreen(navController)
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