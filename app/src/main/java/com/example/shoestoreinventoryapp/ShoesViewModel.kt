package com.example.shoestoreinventoryapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreinventoryapp.classes.Shoe

class ShoesViewModel : ViewModel() {

    val shoes = MutableLiveData<MutableList<Shoe>>()

    init {
        shoes.value = arrayListOf()
    }

    fun add(shoe: Shoe):Unit
    {
        shoes.value?.add(shoe)
    }

}