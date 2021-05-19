package com.example.happyshopper.domain.model

import com.example.happyshopper.presentation.ui.components.CratePos

class ScanCratesListItem(
    val cratePos: Int,
    var crate: Int?,
    val order: Int,
    val bag: String,
    val raw: String,
    val route: Int,
    val drop: Int,
)
