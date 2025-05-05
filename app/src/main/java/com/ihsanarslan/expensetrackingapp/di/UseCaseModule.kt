package com.ihsanarslan.expensetrackingapp.di

import com.ihsanarslan.expensetrackingapp.data.remote.repository.FirebaseAuthImpl
import com.ihsanarslan.expensetrackingapp.domain.usecase.CurrentUserUseCase
import com.ihsanarslan.expensetrackingapp.domain.usecase.SignInWithEmailAndPasswordUseCase
import com.ihsanarslan.expensetrackingapp.domain.usecase.SignOutUseCase
import com.ihsanarslan.expensetrackingapp.domain.usecase.SignUpWithEmailAndPasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideSignInWithEmailAndPasswordUseCase(repository: FirebaseAuthImpl) : SignInWithEmailAndPasswordUseCase {
        return SignInWithEmailAndPasswordUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSignUpWithEmailAndPasswordUseCase(repository: FirebaseAuthImpl) : SignUpWithEmailAndPasswordUseCase {
        return SignUpWithEmailAndPasswordUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSignOutUseCase(repository: FirebaseAuthImpl) : SignOutUseCase {
        return SignOutUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideCurrentUserUseCase(repository: FirebaseAuthImpl) : CurrentUserUseCase {
        return CurrentUserUseCase(repository)
    }


}