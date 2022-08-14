package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel : ViewModel() {
    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    fun addShoe(shoe: Shoe) {
        if (_shoesList.value == null) {
            _shoesList.value = mutableListOf(shoe)
        } else {
            _shoesList.value?.add(shoe)
        }
    }
}