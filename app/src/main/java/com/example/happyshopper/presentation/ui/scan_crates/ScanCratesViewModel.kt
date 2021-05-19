package com.example.happyshopper.presentation.ui.scan_crates

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happyshopper.domain.model.Picklist
import com.example.happyshopper.domain.model.ScanCratesListItem
import com.example.happyshopper.presentation.ui.components.CratePos
import com.example.happyshopper.presentation.ui.components.randomNumber
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
    var data = arrayListOf<ScanCratesListItem>()
    val selectedRow: MutableState<ScanCratesListItem?> = mutableStateOf(null)
//    var randomNumber: Int? = null

    init {
        newSearch()
        addCrateListData()
    }

    /*fun onCrateScanned(cratePos: Int) {
        data[cratePos -1].crate = randomNumber()
    }*/

    fun onSelectedRowChanged(newSelectedRow: ScanCratesListItem?) {
        selectedRow.value = newSelectedRow
    }

    fun addCrateListData() {
        data.add(ScanCratesListItem(1, null,111111, "Y", "Y", 1, 1))
        data.add(ScanCratesListItem(2, null,222222, "N", "Y", 1, 2))
        data.add(ScanCratesListItem(3, null,333333, "N", "N", 1, 3))
        data.add(ScanCratesListItem(4, null,444444, "Y", "N", 1, 4))
        data.add(ScanCratesListItem(5, null,555555, "Y", "Y", 1, 5))
        data.add(ScanCratesListItem(6, null,666666, "Y", "Y", 1, 6))
        data.add(ScanCratesListItem(7, null,777777, "N", "Y", 1, 7))
        data.add(ScanCratesListItem(8, null,888888, "N", "Y", 1, 8))
    }

    fun newSearch() {
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 10,
                query = ""
            )
            picklists.value = result
        }
    }
}