package com.example.happyshopper.network.model

import com.example.happyshopper.domain.model.Picklist
import com.example.happyshopper.domain.util.DomainMapper

class PicklistDtoMapper : DomainMapper<PicklistDto, Picklist> {

    override fun mapToDomainModel(model: PicklistDto): Picklist {
        return Picklist(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            rating = model.rating,
            sourceUrl = model.sourceUrl,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            ingredients = model.ingredients?: listOf(),
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated
        )
    }

    override fun mapFromDomainModel(domainModel: Picklist): PicklistDto {
        return PicklistDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients?: listOf(),
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated
        )
    }

    fun toDomainList(initial: List<PicklistDto>): List<Picklist> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Picklist>): List<PicklistDto> {
        return initial.map { mapFromDomainModel(it) }
    }

}