package com.udacity.shoestore.shoeDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShowDetailsViewModel :ViewModel() {

    private val _isValidateSuccess = MutableLiveData<Boolean>()
    val isValidateSuccess : LiveData<Boolean>
        get() = _isValidateSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String>
        get() = _errorMessage

    init {
        _isValidateSuccess.value = false
    }
    fun validate(name:String, company:String, details:String){
        if(name.isEmpty()){
            _errorMessage.value ="Shoe Name is Empty"
        }else if(company.isEmpty()){
            _errorMessage.value ="Company Name is Empty"
        }else if(details.isEmpty()){
            _errorMessage.value ="details is Empty"
        }else {
            _isValidateSuccess.value = true
        }
    }
}