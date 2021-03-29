package com.example.happyshopper.presentation.ui.picking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.happyshopper.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PickingFragment : Fragment() {
    val viewModel: PickingViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val picklist = viewModel.picklist.value

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
                            .border(border = BorderStroke(1.dp, Color.Black))
                            .fillMaxWidth(0.60f)
                            .height(100.dp)
                    )
                    {
                        Text(text = "TEST COLUMN",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally))
                        Column(
                            modifier = Modifier
                                .border(border = BorderStroke(1.dp, Color.Black))
                        ) {
                            picklist.featuredImage?.let { url ->
                                Image(
                                    painter = painterResource(id = R.drawable.waitrose),
                                    contentDescription = "imgDesc",
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                    Row {
                        OutlinedButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(1.dp)
                            ) {
                            Text(text = "Options")
                        }
                        OutlinedButton(onClick = { findNavController().navigate(R.id.action_pickingFragment_to_itemListFragment) },
                                modifier = Modifier
                                .padding(1.dp)
                            ) {
                            Text(text = "List")
                        }
                        OutlinedButton(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(1.dp)
                                ) {
                            Text(text = "Not On Shelf")
                        }
                    }
                }
            }
        }
    }
}

/*                picklist.title?.let { title ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                    ) {
                        Text(
                            text = title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.Start),
                            )
                    }

                    Column() {

                    picklist.title?.let { title ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                        ) {
                            Text(
                                text = title,
                                modifier = Modifier
                                    .fillMaxWidth(0.85f)
                                    .wrapContentWidth(Alignment.Start),

                            )
                            Text(
                                text = picklist.rating.toString(),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.End)
                                    .align(Alignment.CenterVertically),
                           )
                        }
                    }
                }
            }*/


