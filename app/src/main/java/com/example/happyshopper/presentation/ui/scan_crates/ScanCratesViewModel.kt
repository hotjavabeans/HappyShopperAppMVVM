package com.example.happyshopper.presentation.ui.scan_crates

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happyshopper.domain.model.Picklist
import com.example.happyshopper.repository.PicklistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ScanCratesViewModel
@Inject
constructor(
    private val repository: PicklistRepository,
    private @Named("auth_token") val token: String
): ViewModel() {
    val picklist: MutableState<Picklist> = mutableStateOf(Picklist())
    val picklists: MutableState<List<Picklist>> = mutableStateOf(ArrayList())

    init {
        newSearch()
    }

    fun newSearch() {
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = ""
            )
            picklists.value = result
        }
    }

    fun newGet(id: Int) {
        viewModelScope.launch {
            val result = repository.get(
                token = token,
                id = id
            )
            picklist.value = result
        }
    }
}