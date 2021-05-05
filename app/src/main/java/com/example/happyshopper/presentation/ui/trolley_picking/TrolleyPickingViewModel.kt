package com.example.happyshopper.presentation.ui.trolley_picking

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
class TrolleyPickingViewModel
@Inject
constructor(
    private val repository: PicklistRepository,
    private @Named("auth_token") val token: String
): ViewModel() {
    val picklists: MutableState<List<Picklist>> = mutableStateOf(listOf())
    val loading = mutableStateOf(false)

    init {
        newSearch()
       /* viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 2,
                query = ""
            )
            picklists.value = result
        }*/
    }

    fun newSearch() {
        viewModelScope.launch {
            loading.value = true
            val result = repository.search(
                token = token,
                page = 10,
                query = ""
            )
            picklists.value = result
            loading.value = false
        }
    }
}