package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber
import java.util.regex.Matcher
import java.util.regex.Pattern


class LoginViewModel:ViewModel() {
    private val EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private val _isLoginSuccess = MutableLiveData<Boolean>()
    val isLoginSuccess : LiveData<Boolean>
        get() = _isLoginSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage :LiveData<String>
        get() = _errorMessage
    init {
        Timber.i("LoginViewModel Created")
        _isLoginSuccess.value =false
        _errorMessage.value = ""
    }

    private fun isValidEmail(email: String?): Boolean {
        val pattern: Pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }
    fun login(email:String, password:String){
        if(!isValidEmail(email)){
            _errorMessage.value ="Invalid Email"
        }
        else if(password.isEmpty()){
            _errorMessage.value ="Invalid Password"
        }else{
            _isLoginSuccess.value = true
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("LoginViewModel Cleared")
    }
}