package com.example.happyshopper.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val name: String? = null,
    val price: Double? = null,
    val description: String? = null,
    val lineNumber: Int? = null
) : Parcelable
