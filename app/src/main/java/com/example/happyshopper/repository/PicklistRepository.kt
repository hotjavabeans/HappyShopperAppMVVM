package com.example.happyshopper.repository

import com.example.happyshopper.domain.model.Picklist

interface PicklistRepository {
    suspend fun search(token: String, page: Int, query: String): List<Picklist>
    suspend fun get(token: String, id: Int): Picklist
}