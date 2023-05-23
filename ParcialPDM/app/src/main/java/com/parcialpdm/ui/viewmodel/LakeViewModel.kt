package com.parcialpdm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.parcialpdm.data.model.LakeModel
import com.parcialpdm.repository.LakeRepository
import com.parcialpdm.ui.LakeReviewerApplication

class LakeViewModel(private val repository: LakeRepository): ViewModel() {
    var name = MutableLiveData("")
    var surface = MutableLiveData("")
    var status = MutableLiveData("")

    fun getLakes() = repository.getLakes()

    fun addLakes(lake:LakeModel) = repository.addLakes(lake)

    fun createLake() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val lake = LakeModel(
            name.value!!,
            surface.value!!
        )

        addLakes(lake)
        clearData()

        status.value = LAKE_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            surface.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        surface.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedLake(lake: LakeModel) {
        name.value = lake.name
        surface.value = lake.surface
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as LakeReviewerApplication
                LakeViewModel(app.lakeRepository)
            }
        }

        const val LAKE_CREATED = "Lake created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}