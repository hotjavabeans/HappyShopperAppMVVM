package com.example.happyshopper.presentation.ui.picking

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.happyshopper.R
import com.example.happyshopper.presentation.ui.components.CircularIndeterminateProgressBar
import com.example.happyshopper.util.DEFAULT_RECIPE_IMAGE
import com.example.happyshopper.util.TAG
import com.example.happyshopper.util.loadPicture
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PickingFragment : Fragment() {
    val viewModel: PickingViewModel by viewModels()
    private var itemId: MutableState<Int> = mutableStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        from itemList
        arguments?.getInt("itemId")?.let { iId ->
            if (iId != 0) {
                viewModel.newGet(iId)
            } else {
                return
            }
        }
    }

    @ExperimentalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val picklist = viewModel.picklist.value
                val picklists = viewModel.picklists.value
                val firstItem = viewModel.firstItem.value
                val loading = viewModel.loading.value
                val scannedCount = viewModel.scannedInCount.value

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
                    )
                    {
                        Row() {
                            Text(
                                text = if (itemId.value != 0) {
                                    picklist?.id.let { id ->
                                        "LOCATION: $id"
                                    }
//                                    "LOCATION: ${itemId.value}"
                                } else if(firstItem != null) {
                                    firstItem?.id.let { id ->
                                        "LOCATION: $id"
                                    }
//                                    "LOCATION: ${firstItem.id}"
                                } else {
                                    "Loading..."
                                },
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(start = 4.dp)
//                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = "$scannedCount/${picklists.size}"
                                /*if (itemId.value != null) {
                                    "${itemId.value}/${picklists.size}"
                                } else {
                                    "${firstItem?.id}/${picklists.size}"
                                }*/,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 4.dp, bottom = 4.dp),
                                textAlign = TextAlign.Right
//                                    .align(Alignment.End)
                            )

                        }

                        Row(
                            modifier = Modifier
                                .border(border = BorderStroke(1.dp, Black))
                        ) {
                            arguments?.getInt("itemId")?.let { iId ->
                                if (iId != 0) {
                                    picklist?.featuredImage?.let { url ->
                                        val image = loadPicture(
                                            url = url,
                                            defaultImage = DEFAULT_RECIPE_IMAGE
                                        ).value
                                        image?.let { img ->
                                            Image(
                                                bitmap = img.asImageBitmap(),
                                                contentDescription = "itemImageHere",
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(300.dp)
                                                    .padding(4.dp),
                                                contentScale = ContentScale.Crop
                                            )
                                        }
                                    }
                                    itemId.value = iId
                                } else {
                                    firstItem?.featuredImage?.let { url ->
                                        val image = loadPicture(
                                            url = url,
                                            defaultImage = DEFAULT_RECIPE_IMAGE
                                        ).value
                                        image?.let { img ->
                                            Image(
                                                bitmap = img.asImageBitmap(),
                                                contentDescription = "itemImageHere",
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(300.dp)
                                                    .padding(4.dp),
                                                contentScale = ContentScale.Crop
                                            )
                                        }
                                    }
                                }
                                /*
                                try {
                                    viewModel.newGet(iId)
                                } catch (e: Exception) {
                                    Log.e(TAG, "launchJob: Exception: ${e}, ${e.cause}")
                                    e.printStackTrace()
                                }*/
                            }
                        }

                        Row(
                            modifier = Modifier
                                .padding(start = 4.dp)
                                /*.border(border = BorderStroke(1.dp, Black))*/
                                .fillMaxWidth()
                                .height(100.dp)
                        ) {
                            Box(
                                Modifier.weight(2f)
                            ) {
                                if (itemId.value != 0) {
                                    Text(text = picklist?.title.let { title ->
                                        "DESCRIPTION: $title"
                                    })
                                } else {
                                    Text(text = firstItem?.title.let { title ->
                                        "DESCRIPTION: $title"
                                    })
                                }

                            }
                            Box(
                                Modifier
                                    .weight(1f)
                                    .border(border = BorderStroke(1.dp, Black))
                            ) {
                                Text(
                                    text = "NOTE:",
                                    modifier = Modifier
                                        /*.align(Alignment.Top)*/
                                        .padding(start = 4.dp, end = 4.dp, top = 3.dp, bottom = 2.dp)
                                        .height(100.dp),
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(4.dp)
                            ) {
                                Text(text = "Options")
                            }
                            OutlinedButton(
                                onClick = { findNavController().navigate(R.id.action_pickingFragment_to_itemListFragment) },
                                modifier = Modifier
                                    .padding(4.dp)
                            ) {
                                Text(text = "List")
                            }
                            OutlinedButton(
                                onClick = { viewModel.scanItemIn()

                                    /*if (itemId.value != 0) {
                              viewModel.scanItemIn()
                          } else {
                              viewModel.scanItemIn()
                          }
                               */
                                },
                                modifier = Modifier
                                    .padding(4.dp)
                            ) {
                                Text(text = "Not On Shelf")
                            }
                        }
                    }
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularIndeterminateProgressBar(isDisplayed = loading)
                    }
                }
            }
        }
    }
}