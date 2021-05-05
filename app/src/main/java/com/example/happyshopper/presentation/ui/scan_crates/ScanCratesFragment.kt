package com.example.happyshopper.presentation.ui.scan_crates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.happyshopper.R
import com.example.happyshopper.presentation.ui.components.ScanCratesList
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
                var selectedItem = remember { mutableStateOf(true) }
                val data = viewModel.data

                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFF2F2F2))
                        .fillMaxWidth()
                        .fillMaxSize()
                        .padding(12.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .border(border = BorderStroke(1.dp, Black))
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
                            color = Red,
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
                                onClick = { findNavController().navigate(R.id.action_scanCratesFragment_to_trolleyPickingFragment) },
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
                                .border(border = BorderStroke(1.dp, Black)),
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
                                        selected = selectedItem.value,
                                        onClick = { /*TODO*/ }
                                    )
                                }
                            }
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
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
                                        Toast.makeText(
                                            requireContext(),
                                            "Failed to load item list",
                                            Toast.LENGTH_SHORT
                                        ).show()
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
            }
        }
    }
}
