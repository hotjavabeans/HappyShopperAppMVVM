package com.example.happyshopper.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.happyshopper.R
import com.example.happyshopper.domain.model.Picklist

@Composable
fun TrolleyPickingButtons(
    picklists: List<Picklist>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
//                    .border(border = BorderStroke(1.dp, Color.Black))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = { navController.navigate(R.id.action_trolleyPickingFragment_to_scanCratesFragment) },
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .height(50.dp)
            ) {
                Text(text = if(picklists.isEmpty()) {
                    "Ambient: ..."
                } else {
                    "Ambient: ${picklists.size}"
                }
                    , fontSize = 20.sp)
            }
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .height(50.dp)
            ) {
                Text(text = if(picklists.isEmpty()) {
                    "Chilled: ..."
                } else {
                    "Chilled: ${picklists.size - 3}"
                }
                , fontSize = 20.sp)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .height(50.dp)
            ) {
                Text(text = if(picklists.isEmpty()) {
                    "Frozen: ..."
                } else {
                    "Frozen: ${picklists.size - 22}"
                }
                    , fontSize = 20.sp)
            }
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .height(50.dp)
            ) {
                Text(text = if(picklists.isEmpty()) {
                    "Produce: ..."
                } else {
                    "Produce: ${picklists.size - 9}"
                }
                    , fontSize = 20.sp)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { navController.navigate(R.id.action_trolleyPickingFragment_to_mainMenuFragment) },
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .height(50.dp)
            ) {
                Text(text = "Main Menu", fontSize = 20.sp)
            }
        }
    }
}
