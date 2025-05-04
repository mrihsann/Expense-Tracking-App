package com.ihsanarslan.expensetrackingapp.ui.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.ihsanarslan.expensetrackingapp.domain.model.Expense
import com.ihsanarslan.expensetrackingapp.domain.model.ExpenseCategory
import com.ihsanarslan.expensetrackingapp.navigation.Screen
import com.ihsanarslan.expensetrackingapp.ui.list.components.ListCard
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ListScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<ListViewModel>()
    val isUserAuthenticated = viewModel.isAuthenticated.collectAsStateWithLifecycle()
    val allExpenses = viewModel.allExpense.collectAsStateWithLifecycle()

    LaunchedEffect(isUserAuthenticated.value) {
        if (!isUserAuthenticated.value) {
            navController.navigate(Screen.Login)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (allExpenses.value.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No expenses yet",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(allExpenses.value) { expense ->
                    ListCard(
                        expense = expense,
                        onDelete = { viewModel.deleteExpense(expense.id!!) }
                    )
                }
            }
        }
    }
}



@Composable
fun getCategoryIcon(category: ExpenseCategory): ImageVector {
    return when (category) {
        ExpenseCategory.FOOD -> Icons.Outlined.Restaurant
        ExpenseCategory.SHOPPING -> Icons.Outlined.ShoppingCart
        ExpenseCategory.TRANSPORT -> Icons.Outlined.DirectionsCar
        ExpenseCategory.ENTERTAINMENT -> Icons.Outlined.Movie
        ExpenseCategory.BILLS -> Icons.Outlined.Receipt
        ExpenseCategory.HEALTH -> Icons.Outlined.LocalHospital
        ExpenseCategory.OTHER -> Icons.Outlined.MoreHoriz
    }
}