package com.ihsanarslan.expensetrackingapp.di

import com.google.firebase.auth.FirebaseAuth
import com.ihsanarslan.expensetrackingapp.data.remote.repository.FirebaseAuthImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFirebaseAuthImpl(auth: FirebaseAuth) : FirebaseAuthImpl {
        return FirebaseAuthImpl(auth)
    }

}