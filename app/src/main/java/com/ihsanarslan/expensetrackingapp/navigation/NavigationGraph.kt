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
        composable<Auth> {
            AuthScreen(navController)
        }
        composable<Home> {
            HomeScreen(navController)
        }
        composable<Detail> {
            DetailScreen(navController)
        }
        composable<Settings> {
            SettingsScreen(navController)
        }
        composable<Tracking> {
            TrackingScreen(navController)
        }
        composable<Add> {
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