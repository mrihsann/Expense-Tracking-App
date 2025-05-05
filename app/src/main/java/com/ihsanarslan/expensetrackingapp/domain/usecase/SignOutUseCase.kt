package com.ihsanarslan.expensetrackingapp.domain.usecase

import com.ihsanarslan.expensetrackingapp.data.remote.repository.FirebaseAuthImpl
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val repo : FirebaseAuthImpl
) {
    suspend operator fun invoke(){
        repo.signOut()
    }
}