package com.example.happyshopper.presentation.ui.picking

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
class PickingViewModel
@Inject
constructor(
    private val repository: PicklistRepository,
    private @Named("auth_token") val token: String
): ViewModel() {
    val picklist: MutableState<Picklist?> = mutableStateOf(null)
//    val picklist: MutableState<Picklist> = mutableStateOf(Picklist())
    val picklists: MutableState<List<Picklist>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)
    val firstItem: MutableState<Picklist?> = mutableStateOf(null)


    init {
        newSearch()
//        getFirstItem()
//        newGet(2079)
    }
   /* fun getFirstItem() {
        val first = picklists.value.first()
        firstItem.value = first
    }*/

    fun newGet(id: Int) {
        viewModelScope.launch {
            loading.value = true
            val result = repository.get(
                token = token,
                id = id
            )
            picklist.value = result
            loading.value = false
        }
    }
    fun newSearch() {
        viewModelScope.launch {
            loading.value = true
            val result = repository.search(
                token = token,
                page = 1,
                query = ""
            )
            picklists.value = result
            firstItem.value = result[0]
            loading.value = false
        }
    }
}