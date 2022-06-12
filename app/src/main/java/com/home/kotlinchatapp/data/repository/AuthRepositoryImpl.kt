package com.home.kotlinchatapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.home.kotlinchatapp.domain.model.Response
import com.home.kotlinchatapp.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {
    override fun isAuthenticated() = auth.currentUser != null

    override suspend fun signInAnonymously() = flow {
        try {
            emit(Response.Loading)
            auth.signInAnonymously().await()
            emit(Response.Success(true))
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: e.toString()))
        }
    }

    override suspend fun signOut(): Flow<Response<Boolean>> {
        TODO("Not yet implemented")
    }

    override fun getAuthState(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}