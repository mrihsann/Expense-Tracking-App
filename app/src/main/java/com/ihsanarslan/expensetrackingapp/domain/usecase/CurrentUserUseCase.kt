package com.ihsanarslan.expensetrackingapp.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.ihsanarslan.expensetrackingapp.data.remote.repository.FirebaseAuthImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrentUserUseCase @Inject constructor(
    private val repo : FirebaseAuthImpl
) {
    operator fun invoke() : Flow<FirebaseUser?> = flow {
        repo.currentUser().collect {
            emit(it)
        }
    }
}