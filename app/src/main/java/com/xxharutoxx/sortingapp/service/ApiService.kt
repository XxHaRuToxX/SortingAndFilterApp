package com.xxharutoxx.sortingapp.service

import com.xxharutoxx.sortingapp.response.TokenResponse
import retrofit2.http.POST

interface ApiService {
    @POST("/api/v1/users/refresh-token/")
    suspend fun refreshAccessToken(): TokenResponse
}