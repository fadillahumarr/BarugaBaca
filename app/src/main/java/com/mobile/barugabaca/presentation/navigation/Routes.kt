package com.mobile.barugabaca.presentation.navigation

//Membuat routes untuk masing-masing screen
sealed class Routes(val route:String) {
    object Login: Routes("login")
    object SignUp: Routes("signup")
    object Home: Routes("home")
}