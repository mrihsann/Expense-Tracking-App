package com.ihsanarslan.expensetrackingapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.ihsanarslan.expensetrackingapp.domain.model.Expense
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val auth : FirebaseAuth,
    private val db : FirebaseDatabase
) : ViewModel() {

    private val userId = auth.currentUser?.uid ?: ""

    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean>
        get() = _isAuthenticated.asStateFlow()

    private val _allExpense = MutableStateFlow<List<Expense>>(emptyList())
    val allExpense: StateFlow<List<Expense>>
        get() = _allExpense.asStateFlow()

    init {
        isUserAuthenticated()
        getAllExpense()
    }

    fun signOut(){
        viewModelScope.launch {
            auth.signOut()
            _isAuthenticated.value = false
        }
    }

    fun isUserAuthenticated(){
        val isActive = auth.currentUser != null
        _isAuthenticated.value = isActive
    }

    fun getAllExpense(){
        db.getReference("expenses").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (expenseSnapshot in snapshot.children) {
                    val expense = expenseSnapshot.getValue(Expense::class.java)
                    if (expense != null && expense.userId == userId) {
                        _allExpense.value.plus(expense)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}