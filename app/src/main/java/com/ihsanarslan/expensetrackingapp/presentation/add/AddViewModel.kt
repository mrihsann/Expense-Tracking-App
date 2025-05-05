package com.ihsanarslan.expensetrackingapp.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.FirebaseDatabase
import com.ihsanarslan.expensetrackingapp.domain.model.Expense
import com.ihsanarslan.expensetrackingapp.domain.model.ExpenseCategory
import com.ihsanarslan.expensetrackingapp.domain.usecase.CurrentUserUseCase
import com.ihsanarslan.expensetrackingapp.util.Constants
import com.ihsanarslan.expensetrackingapp.util.Constants.REFS_EXPENSES
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val db : FirebaseDatabase,
    private val currentUserUseCase: CurrentUserUseCase
) :ViewModel(){

    fun addExpense(
        title: String,
        description: String,
        amount: Double,
        category: ExpenseCategory,
        date: Date
    ) {
        viewModelScope.launch {

            val userId = currentUserUseCase().first()?.uid ?: return@launch
            val ref = db.reference.child(REFS_EXPENSES).push()
            val id = ref.key ?: return@launch

            val expense = Expense(
                id = id,
                userId = userId,
                title = title,
                description = description,
                amount = amount,
                category = category,
                date = date
            )

            ref.setValue(expense)
        }
    }
}