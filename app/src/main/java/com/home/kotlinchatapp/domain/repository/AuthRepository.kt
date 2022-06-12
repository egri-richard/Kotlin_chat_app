package com.home.kotlinchatapp.domain.repository

import com.home.kotlinchatapp.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun isAuthenticated(): Boolean

    suspend fun signInAnonymously(): Flow<Response<Boolean>>

    suspend fun signOut(): Flow<Response<Boolean>>

    fun getAuthState(): Flow<Boolean>
}