package com.example.happyshopper.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.happyshopper.domain.model.ScanCratesListItem


@Composable
fun ScanCratesList(scanCratesListItem: ScanCratesListItem,
                   selected: Boolean,
                   onClick: () -> Unit) {


    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .selectable(selected = selected, onClick = onClick)
            .border(border = BorderStroke(1.dp, Color.Black)),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(scanCratesListItem.cratePos.toString())
            Text(scanCratesListItem.order.toString())
            Text(scanCratesListItem.bag)
            Text(scanCratesListItem.raw)
            Text(scanCratesListItem.route.toString())
            Text(scanCratesListItem.drop.toString())
        }
    }
}