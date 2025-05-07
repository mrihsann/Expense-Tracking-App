package com.ihsanarslan.expensetrackingapp.di

import android.content.Context
import com.ihsanarslan.expensetrackingapp.data.local.AppDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalStorageModule {

    @Provides
    @Singleton
    fun provideAppDataStore(@ApplicationContext context: Context): AppDataStore {
        return AppDataStore(context)
    }

}