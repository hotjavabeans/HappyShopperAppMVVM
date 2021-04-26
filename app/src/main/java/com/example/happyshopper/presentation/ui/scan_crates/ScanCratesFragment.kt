package com.example.happyshopper.presentation.ui.scan_crates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.happyshopper.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScanCratesFragment : Fragment() {

    val viewModel: ScanCratesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val picklists = viewModel.picklists.value

                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFF2F2F2))
                        .fillMaxWidth()
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .background(color = Color.LightGray)
                    ) {
                        OutlinedButton(
                            onClick = {
                                if (picklists[0].id != null) {
                                    val bundle = Bundle()
                                    picklists[0].id?.let { bundle.putInt("id", it) }
                                    findNavController().navigate(
                                        R.id.action_scanCratesFragment_to_pickingFragment,
                                        bundle
                                    )
                                } else {
                                    Toast.makeText(requireContext(), "Failed to load item list", Toast.LENGTH_SHORT).show()
                                }
                            },
                            modifier = Modifier
                                .height(50.dp)
                        ) {
                            Text(text = "Start", fontSize = 20.sp)
                        }
                        OutlinedButton(
                            onClick = { findNavController().navigate(R.id.action_scanCratesFragment_to_trolleyPickingFragment) },
                            shape = RoundedCornerShape(10),
                            modifier = Modifier
                                .height(50.dp)
                        ) {
                            Text(text = "Cancel", fontSize = 20.sp)
                        }
                        OutlinedButton(
                            onClick = { /*PRINT LABELS DIALOG*/ },
                            shape = RoundedCornerShape(10),
                            modifier = Modifier
                                .height(50.dp)
                        ) {
                            Text(text = "Print", fontSize = 20.sp)
                        }
                        Column(
                            modifier = Modifier
                                .padding(5.dp, 40.dp)
//                            .verticalScroll(rememberScrollState())
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "TYPE",
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .background(color = Color(0xFFF2F2F2))
                                    .border(border = BorderStroke(1.dp, Color.Black))
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                        .padding(5.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "ITEM TITLE",
                                        modifier = Modifier.align(Alignment.CenterVertically)
                                    )
//                            Text(text = "${recipe.rating}", modifier = Modifier.align(Alignment.CenterVertically))
//                            Text(text = "${recipe.dateAdded}", modifier = Modifier.align(Alignment.CenterVertically))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
