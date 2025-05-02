package com.ihsanarslan.expensetrackingapp.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.ihsanarslan.expensetrackingapp.data.repository.FirebaseAuthImpl
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