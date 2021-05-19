package com.example.happyshopper.presentation.ui.components

import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.happyshopper.R
import com.example.happyshopper.domain.model.Picklist
import com.example.happyshopper.domain.model.ScanCratesListItem

@Composable
fun ScanCratesScreen(
    data: ArrayList<ScanCratesListItem>,
    picklists: List<Picklist>,
    navController: NavController,
    selectedRow: ScanCratesListItem?,
    onSelectedRowChanged: (ScanCratesListItem) -> Unit,
    ) {
    Column(
        modifier = Modifier
            .border(border = BorderStroke(1.dp, Color.Black))
    ) {
        Text(
            modifier = Modifier
                .padding(start = 4.dp, bottom = 4.dp)
                .align(alignment = Alignment.CenterHorizontally),
            text = "Ambient Picklist" /*random ID here?*/,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 4.dp, bottom = 4.dp)
                .align(alignment = Alignment.CenterHorizontally),
            text = "Scan crate barcodes",
            color = Color.Red,
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedButton(
                onClick = { /*PRINT LABELS DIALOG*/ },
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .height(50.dp)
                    .padding(start = 4.dp, bottom = 4.dp)
            ) {
                Text(text = "Print", fontSize = 20.sp)
            }

            OutlinedButton(
                onClick = { /*CLEAR SELECTED CRATE*/ },
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .height(50.dp)
                    .padding(bottom = 4.dp)
            ) {
                Text(text = "Clear Crate", fontSize = 20.sp)
            }
            OutlinedButton(
                onClick = { navController.navigate(R.id.action_scanCratesFragment_to_trolleyPickingFragment) },
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .height(50.dp)
                    .padding(end = 4.dp, bottom = 4.dp)
            ) {
                Text(text = "Cancel", fontSize = 20.sp)
            }
        }
        Column(
            modifier = Modifier
        ) {
            Row(modifier = Modifier
                .background(color = Color(0xFF609EE6))
                .fillMaxWidth()
                .border(border = BorderStroke(1.dp, Color.Black)),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("#")
                Text("Crate")
                Text("Order")
                Text("Bag?")
                Text("Raw?")
                Text("Route")
                Text("Drop")
            }
            LazyColumn() {
                itemsIndexed(
                    items = data
                ) { index, cratePosItem ->
                    ScanCratesList(scanCratesListItem = cratePosItem,
                        isSelected = selectedRow == cratePosItem,
                        onSelectedRowChanged = {
                            onSelectedRowChanged(it)
                        }
                    )
                }
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            OutlinedButton(
                onClick = { data[selectedRow?.cratePos!!].crate = randomNumber()  },
                modifier = Modifier
                    .height(50.dp)
                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
            ) {
                Text(text = "Scan Crate", fontSize = 20.sp)
            }
            OutlinedButton(
                onClick = {
                    if (picklists[0].id != null) {
                        val bundle = Bundle()
                        picklists[0].id?.let { bundle.putInt("id", it) }
                        navController.navigate(
                            R.id.action_scanCratesFragment_to_pickingFragment,
                            bundle
                        )
                    } else {

                    }
                },
                modifier = Modifier
                    .height(50.dp)
                    .padding(bottom = 4.dp, end = 4.dp, top = 4.dp)
            ) {
                Text(text = "Start", fontSize = 20.sp)
            }
        }
    }
}