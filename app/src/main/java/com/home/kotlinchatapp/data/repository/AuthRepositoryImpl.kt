package com.home.kotlinchatapp.data.repository

import androidx.compose.foundation.isSystemInDarkTheme
import com.google.firebase.auth.FirebaseAuth
import com.home.kotlinchatapp.domain.model.AuthResponse
import com.home.kotlinchatapp.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Exception

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {
    override fun isAuthenticated() = auth.currentUser != null

    override suspend fun signWithEmail(email: String, password: String) = flow {
        try {
            emit(AuthResponse.Loading)
            auth.signInWithEmailAndPassword(email, password).await()
            emit(AuthResponse.Success(true))
        } catch (e: Exception) {
            emit(AuthResponse.Error(e.message.toString()))
        }
    }

    override suspend fun registerWithEmail(email: String, password: String) = flow {
        try {
            emit(AuthResponse.Loading)
            auth.createUserWithEmailAndPassword(email, password).await()
            emit(AuthResponse.Success(true))
        } catch (e: Exception) {
            emit(AuthResponse.Error(e.message.toString()))
        }
    }

    override suspend fun signOut() = flow {
        try {
            emit(AuthResponse.Loading)
            auth.signOut()
            emit(AuthResponse.Success(true))
        } catch (e: Exception) {
            emit(AuthResponse.Error(e.message.toString()))
        }
    }
}