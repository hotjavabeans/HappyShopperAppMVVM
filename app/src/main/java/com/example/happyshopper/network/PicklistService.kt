package com.example.happyshopper.network

import com.example.happyshopper.network.model.PicklistDto
import com.example.happyshopper.network.model.responses.PicklistSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PicklistService {
    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): PicklistSearchResponse

    @GET("get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): PicklistDto
}

