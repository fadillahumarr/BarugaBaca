package com.mobile.barugabaca.data

class LoginRepository {
    fun login(email: String, password: String): User {
        return User(email, password)
    }
}