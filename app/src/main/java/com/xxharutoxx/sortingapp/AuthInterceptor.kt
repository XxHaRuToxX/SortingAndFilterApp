package com.xxharutoxx.sortingapp

import com.xxharutoxx.sortingapp.service.ApiService
import com.xxharutoxx.sortingapp.service.SessionManager
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val apiService: ApiService):Interceptor {
    private val sessionManager = SessionManager() // Replace with your session management class

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val accessToken = sessionManager.getAccessToken()

        if (accessToken != null && sessionManager.isAccessTokenExpired()) {
            val refreshToken = sessionManager.getRefreshToken()

            // Make the token refresh request
            val refreshedToken = runBlocking {
                val response = apiService.refreshAccessToken()
                // Update the refreshed access token and its expiration time in the session
                sessionManager.updateAccessToken(response.accessToken, response.expiresIn)
                response.accessToken
            }

            if (refreshedToken != null) {
                // Create a new request with the refreshed access token
                val newRequest = originalRequest.newBuilder()
                    .header("Authorization", "Bearer $refreshedToken")
                    .build()

                // Retry the request with the new access token
                return chain.proceed(newRequest)
            }
        }

        // Add the access token to the request header
        val authorizedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $accessToken")
            .build()

        return chain.proceed(authorizedRequest)
    }
}