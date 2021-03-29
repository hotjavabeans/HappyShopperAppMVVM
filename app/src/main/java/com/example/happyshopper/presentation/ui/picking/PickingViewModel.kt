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
    val picklist: MutableState<Picklist> = mutableStateOf(Picklist())

    init {
        viewModelScope.launch {
            val result = repository.get(
                token = token,
                id = 583
            )
            picklist.value = result
        }
    }
   /* fun newGet() {}*/
}