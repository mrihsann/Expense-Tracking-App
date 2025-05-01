package com.ihsanarslan.expensetrackingapp.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.ihsanarslan.expensetrackingapp.domain.model.Expense
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val db : FirebaseDatabase,
    private val auth : FirebaseAuth
) :ViewModel(){

    fun addExpense(
        title: String,
        description: String,
        amount: Double,
    ) {

        viewModelScope.launch {
            val id = db.getReference("expenses").push().key ?: return@launch
            val userId = auth.currentUser?.uid ?: return@launch
            val expense = Expense(
                id = id,
                userId = userId.toString(),
                title = title,
                description = description,
                amount = amount
            )

            db.reference.child("expenses").push().setValue(expense)
        }
    }

}