package com.udacity.shoestore.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<String>>()
    val shoeList :LiveData<MutableList<String>>
        get() = _shoeList

    init {
      _shoeList.value = mutableListOf(
          "Sneakers",
          "Loafers",
          "Oxfords",
          "Boots",
          "Sandals",
          "High Heels",
          "Flats",
          "Espadrilles",
          "Athletic Shoes",
          "Slippers",
          "Platform Shoes",
          "Moccasins",
          "Clogs",
          "Wedge Heels",
          "Brogues",
          "Pumps",
          "Flip-Flops",
          "Wingtips",
          "Hiking Boots",
          "Boat Shoes",
          "Rain Boots",
          "Mules",
          "Chukka Boots",
          "Thong Sandals",
          "Slingbacks"
      )
    }
}