package com.mobile.barugabaca.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobile.barugabaca.presentation.home.HomeContent
import com.mobile.barugabaca.presentation.login.LoginContent
import com.mobile.barugabaca.presentation.login.LoginViewModel
import com.mobile.barugabaca.presentation.signup.SignUpContent

@Composable
fun MyAppNavigation(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.Login.route ) {
        composable(Routes.Login.route) {
            val loginViewModel: LoginViewModel = viewModel()
            LoginContent(loginViewModel, navController)
        }
        composable(Routes.SignUp.route) {
            SignUpContent(navController)
        }
        composable(Routes.Home.route) {
            HomeContent(navController)
        }
    }
}