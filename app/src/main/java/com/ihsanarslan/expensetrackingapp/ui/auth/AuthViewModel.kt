package com.ihsanarslan.expensetrackingapp.ui.auth

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val auth : FirebaseAuth
) : ViewModel() {

    fun signUp(email : String, password : String, passwordConfirmation : String){

        if (password == passwordConfirmation){
            auth.createUserWithEmailAndPassword(email, password)
        }else{
            // Show error message
            println("Passwords do not match")
        }

    }
}