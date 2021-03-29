package com.example.happyshopper.network.model.responses

import com.example.happyshopper.network.model.PicklistDto
import com.google.gson.annotations.SerializedName

data class PicklistSearchResponse(
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var picklists: List<PicklistDto>
)