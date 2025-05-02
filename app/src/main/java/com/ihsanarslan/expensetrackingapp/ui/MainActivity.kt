package com.ihsanarslan.expensetrackingapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ihsanarslan.expensetrackingapp.navigation.NavigationGraph
import com.ihsanarslan.expensetrackingapp.navigation.Screen
import com.ihsanarslan.expensetrackingapp.ui.components.BottomBar
import com.ihsanarslan.expensetrackingapp.ui.theme.MyappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyappTheme {
                val navController = rememberNavController()
                val startDestination = Screen.Login
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                Scaffold (
                    topBar = {
                        val title = when {
                            currentDestination?.hierarchy?.any { it.route?.contains(Screen.Home::class.simpleName ?: "") == true } == true -> "Home Screen"
                            currentDestination?.hierarchy?.any { it.route?.contains(Screen.List::class.simpleName ?: "") == true } == true -> "List Screen"
                            currentDestination?.hierarchy?.any { it.route?.contains(Screen.Settings::class.simpleName ?: "") == true } == true -> "Settings"
                            currentDestination?.hierarchy?.any { it.route?.contains(Screen.Add::class.simpleName ?: "") == true } == true -> "Add Expense"
                            currentDestination?.hierarchy?.any { it.route?.contains(Screen.Detail::class.simpleName ?: "") == true } == true -> "Detail"
                            // Uygulamanızdaki diğer ekranları buraya ekleyebilirsiniz
                            currentDestination == null -> "Uygulama Adı" // Başlangıç değeri
                            else -> "Not Found"
                        }
                        if(currentDestination?.hierarchy?.any { it.route?.contains(Screen.Login::class.simpleName ?: "") == true } == false || currentDestination?.hierarchy?.any { it.route?.contains(Screen.Register::class.simpleName ?: "") == true } == false){
                            CenterAlignedTopAppBar(
                                title = {
                                    Text(title)
                                }
                            )
                        }
                    },
                    bottomBar = {
                        if(currentDestination?.hierarchy?.any { it.route?.contains(Screen.Login::class.simpleName ?: "") == true } == false || currentDestination?.hierarchy?.any { it.route?.contains(Screen.Register::class.simpleName ?: "") == true } == false){
                            BottomBar(navController)
                        }
                    }
                ){
                    innerPadding ->
                    NavigationGraph(
                        navController = navController,
                        startDestination = startDestination,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}