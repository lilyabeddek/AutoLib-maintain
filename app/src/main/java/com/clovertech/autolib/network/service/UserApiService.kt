package com.clovertech.autolib.network.service

import com.clovertech.autolib.model.Tache
import com.clovertech.autolib.model.Utilisateur
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {
    @GET("users/{id}")
    suspend fun getUserById(@Path("id")id: Int): Response<Utilisateur>
}