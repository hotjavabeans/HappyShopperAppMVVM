package com.example.happyshopper.presentation.ui.item_list

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
class ItemListViewModel
@Inject
constructor(
    private val repository: PicklistRepository,
    private @Named("auth_token") val token: String
) : ViewModel() {
    val picklists: MutableState<List<Picklist>> = mutableStateOf(ArrayList())
//    val id: MutableState<Int> = mutableStateOf(0)
//    val selectedItem = mutableStateOf(null)
//    val query = mutableStateOf("") /*eg "ambient/frozen"*/

    init {
        newSearch()
    }
    fun newSearch() {
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = "chicken"
            )
            picklists.value = result
        }
    }
    /*fun getId(id: Int) {
        viewModelScope.launch {
            val result = repository.get(
                token = token,
                id = 584
            )
            id.value = result.id
        }
    }*/
}