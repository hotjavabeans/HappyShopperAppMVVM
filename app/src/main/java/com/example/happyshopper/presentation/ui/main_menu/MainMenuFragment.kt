package com.example.happyshopper.presentation.ui.main_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.navigation.fragment.findNavController
import com.example.happyshopper.R

class MainMenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFF2F2F2))
                        .fillMaxWidth()
                        .fillMaxHeight()
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
                            .fillMaxSize()
                            .border(border = BorderStroke(1.dp, Color.Black))
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
//                                .border(border = BorderStroke(1.dp, Color.Red))
                            ,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            OutlinedButton(
                                onClick = { findNavController().navigate(R.id.action_mainMenuFragment_to_trolleyPickingFragment) },
                                shape = RoundedCornerShape(10),
                            ) {
                                Text(text = "Trolley \nPicking", fontSize = 20.sp)
                            }
                            OutlinedButton(
                                onClick = {},
                                shape = RoundedCornerShape(10),

                                ) {
                                Text(text = "Exception \nPicking", fontSize = 20.sp)
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
//                                .border(border = 0BorderStroke(1.dp, Color.Green))
                                ,
                            horizontalArrangement = Arrangement.Center
                        ) {
                        }
                    }
                }
            }
        }
    }
}
