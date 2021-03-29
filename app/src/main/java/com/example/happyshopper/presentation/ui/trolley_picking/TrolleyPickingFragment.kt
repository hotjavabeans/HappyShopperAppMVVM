package com.example.happyshopper.presentation.ui.trolley_picking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.happyshopper.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrolleyPickingFragment: Fragment() {
    val viewModel: TrolleyPickingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val picklist = viewModel.picklists.value
                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFF2F2F2))
                        .fillMaxWidth()
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.waitrose),
                        contentDescription = null,
                        modifier = Modifier
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop,
                    )
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
                                onClick = { findNavController().navigate(R.id.action_trolleyPickingFragment_to_scanCratesFragment) },
                                shape = RoundedCornerShape(10),
                                modifier = Modifier
                                    .height(50.dp)
                            ) {
                                Text(text = "Ambient: ${picklist.size}", fontSize = 20.sp)
                            }
                            OutlinedButton(
                                onClick = {},
                                shape = RoundedCornerShape(10),
                                modifier = Modifier
                                    .height(50.dp)
                            ) {
                                Text(text = "Chilled", fontSize = 20.sp)
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
                                Text(text = "Frozen", fontSize = 20.sp)
                            }
                            OutlinedButton(
                                onClick = {},
                                shape = RoundedCornerShape(10),
                                modifier = Modifier
                                    .height(50.dp)
                            ) {
                                Text(text = "Produce", fontSize = 20.sp)
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
                                onClick = { findNavController().navigate(R.id.action_trolleyPickingFragment_to_mainMenuFragment) },
                                shape = RoundedCornerShape(10),
                                modifier = Modifier
                                    .height(50.dp)
                            ) {
                                Text(text = "Main Menu", fontSize = 20.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}