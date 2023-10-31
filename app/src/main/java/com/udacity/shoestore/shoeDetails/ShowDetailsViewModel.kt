package com.udacity.shoestore.shoeDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShowDetailsViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val companyName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeDetails = MutableLiveData<String>()

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    private val _saveEventComplete = MutableLiveData<Boolean>()
    val saveEventComplete: LiveData<Boolean>
        get() = _saveEventComplete

    init {
        shoeName.value = ""
        shoeSize.value = "1"
        companyName.value = ""
        shoeDetails.value = ""
        _errorMessage.value = ""
        _saveEventComplete.value = false
    }

    fun save() {
        if (shoeName.value!!.isEmpty()) {
            _errorMessage.value = "Shoe Name is Empty"
        } else if (companyName.value!!.isEmpty()) {
            _errorMessage.value = "company Name is Empty"
        } else if (shoeSize.value!!.isEmpty()) {
            _errorMessage.value = "Shoe Size is Empty"
        } else if (shoeDetails.value!!.isEmpty()) {
            _errorMessage.value = "Shoe Details is Empty"
        } else {
            _saveEventComplete.value = true
        }
    }

    fun onSaveEventComplete() {
        _saveEventComplete.value = false
    }
}