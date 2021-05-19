package com.example.happyshopper.presentation.ui.scan_crates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.happyshopper.presentation.ui.components.ScanCratesScreen
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
                val data = viewModel.data
                val selectedRow = viewModel.selectedRow.value

                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFF2F2F2))
                        .fillMaxWidth()
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    ScanCratesScreen(
                        data = data,
                        picklists = picklists,
                        navController = findNavController(),
                        selectedRow = selectedRow,
                        onSelectedRowChanged = viewModel::onSelectedRowChanged
                    )
                }
            }
        }
    }
}
