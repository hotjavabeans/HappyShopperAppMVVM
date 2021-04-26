package com.example.happyshopper.presentation.ui.item_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.happyshopper.R
import com.example.happyshopper.presentation.ui.components.PicklistCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemListFragment: Fragment() {
    private val viewModel: ItemListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val items = viewModel.picklists.value


                Column(modifier = Modifier
                    .fillMaxSize()
                ) {
                    LazyColumn()
                    {
                        itemsIndexed(
                            items = items
                        ) { index, picklist ->
                            PicklistCard(picklist = picklist, onClick =
                            {
                                if (picklist.id != null) {
                                    val bundle = Bundle()
                                    bundle.putInt("itemId", picklist.id)
                                    findNavController().navigate(
                                        R.id.action_itemListFragment_to_pickingFragment, bundle)
                                }
                            }
                            )
                        }
                    }
                }
            }
        }
    }
}