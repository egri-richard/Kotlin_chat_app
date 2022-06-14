package com.home.kotlinchatapp.domain.repository

import com.home.kotlinchatapp.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun isAuthenticated(): Boolean

    suspend fun signWithEmail(email: String, password: String): Flow<AuthResponse<Boolean>>

    suspend fun registerWithEmail(email: String, password: String): Flow<AuthResponse<Boolean>>

    suspend fun signOut(): Flow<AuthResponse<Boolean>>

    fun getAuthState(): Flow<Boolean>
}