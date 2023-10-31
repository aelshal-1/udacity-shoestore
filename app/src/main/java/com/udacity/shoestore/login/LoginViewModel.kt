package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber
import java.util.regex.Matcher
import java.util.regex.Pattern


class LoginViewModel:ViewModel() {
    private val EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private val _eventLoginFinish = MutableLiveData<Boolean>()
    val isLoginSuccess : LiveData<Boolean>
        get() = _eventLoginFinish


    val email = MutableLiveData<String>()

    val password =MutableLiveData<String>()

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage :LiveData<String>
        get() = _errorMessage
    init {
        Timber.i("LoginViewModel Created")
        _eventLoginFinish.value =false
        _errorMessage.value = ""
    }


    private fun isValidEmail(): Boolean {
        if(email.value == null)
            return false
        val pattern: Pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher: Matcher = pattern.matcher(email.value!!)
        return matcher.matches()
    }
    fun login(){
        if(!isValidEmail()){
            _errorMessage.value ="Invalid Email"
        }
        else if(password.value!!.isEmpty()){
            _errorMessage.value ="Invalid Password"
        }else{
            _eventLoginFinish.value = true
        }
    }

    fun onLoginFinishComplete(){
        _eventLoginFinish.value =false
    }

}