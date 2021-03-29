package com.example.happyshopper.di

import com.example.happyshopper.network.PicklistService
import com.example.happyshopper.network.model.PicklistDtoMapper
import com.example.happyshopper.repository.PicklistRepository
import com.example.happyshopper.repository.PicklistRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePicklistRepository(
        picklistService: PicklistService,
        picklistDtoMapper: PicklistDtoMapper
    ): PicklistRepository {
        return PicklistRepository_Impl(picklistService, picklistDtoMapper)
    }
}