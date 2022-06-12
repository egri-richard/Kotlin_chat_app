package com.home.kotlinchatapp.di

import com.google.firebase.auth.FirebaseAuth
import com.home.kotlinchatapp.data.repository.AuthRepositoryImpl
import com.home.kotlinchatapp.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(
        auth: FirebaseAuth
    ): AuthRepository = AuthRepositoryImpl(auth)
}