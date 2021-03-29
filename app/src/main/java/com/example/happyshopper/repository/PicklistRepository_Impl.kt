package com.example.happyshopper.repository

import com.example.happyshopper.network.PicklistService
import com.example.happyshopper.domain.model.Picklist
import com.example.happyshopper.network.model.PicklistDtoMapper

class PicklistRepository_Impl(
    private val picklistService: PicklistService,
    private val mapper: PicklistDtoMapper
): PicklistRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Picklist> {
        return mapper.toDomainList(picklistService.search(token, page, query).picklists)
    }

    override suspend fun get(token: String, id: Int): Picklist {
        return mapper.mapToDomainModel(picklistService.get(token, id))
    }
}