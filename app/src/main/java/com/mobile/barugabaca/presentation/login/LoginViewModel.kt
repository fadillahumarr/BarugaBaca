package com.mobile.barugabaca.presentation.login

import androidx.lifecycle.ViewModel
import com.mobile.barugabaca.data.LoginRepository
import com.mobile.barugabaca.data.User

class LoginViewModel : ViewModel() {
    private val loginRepository = LoginRepository()
    var loginRequest: User? = null

    fun login(email: String, password: String) {
        loginRequest = loginRepository.login(email, password)
    }
}