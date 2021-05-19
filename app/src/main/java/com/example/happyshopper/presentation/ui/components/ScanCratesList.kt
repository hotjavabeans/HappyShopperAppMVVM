package com.example.happyshopper.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.happyshopper.domain.model.ScanCratesListItem

@Composable
fun ScanCratesList(scanCratesListItem: ScanCratesListItem,
                    isSelected: Boolean = false,
                    onSelectedRowChanged: (ScanCratesListItem) -> Unit
) {
    
        /*.selectable(
            selected = scanCratesListItem.cratePos == selectedIndex,
            onClick = { if(selectedIndex != scanCratesListItem.cratePos)
                Modifier.background(color = Color.Green) else Modifier.background(color = Color.Red)})*/

    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectedRowChanged(scanCratesListItem)
                }
            )
            .background(color = if (isSelected) Color.Green else Color.Unspecified)
            .border(border = BorderStroke(1.dp, Color.Black))
            ,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(scanCratesListItem.cratePos.toString())
            Text(scanCratesListItem.crate.toString())
            Text(scanCratesListItem.order.toString())
            Text(scanCratesListItem.bag)
            Text(scanCratesListItem.raw)
            Text(scanCratesListItem.route.toString())
            Text(scanCratesListItem.drop.toString())
        }
    }
}