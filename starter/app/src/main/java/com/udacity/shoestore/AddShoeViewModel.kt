package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class AddShoeViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun getShoe() : Shoe {
        return Shoe(
            name.value ?: "",
            size.value?.toDouble() ?: 0.0,
            company.value ?: "",
            description.value ?: "",
            arrayListOf(""))
    }
}