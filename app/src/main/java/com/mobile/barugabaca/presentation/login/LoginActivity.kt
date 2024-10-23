package com.mobile.barugabaca.presentation.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobile.barugabaca.presentation.components.CustomOutlinedTextField
import com.mobile.barugabaca.presentation.components.PrimaryButton
import com.mobile.barugabaca.presentation.navigation.MyAppNavigation
import com.mobile.barugabaca.presentation.navigation.Routes
import com.mobile.barugabaca.ui.theme.BarugaBacaTheme
import com.mobile.barugabaca.ui.theme.PrimaryColor

class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarugaBacaTheme {
                MyAppNavigation()
            }
        }
    }
}

// Composable function for login content
@Composable
fun LoginContent(loginViewModel: LoginViewModel, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isButtonClicked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Masuk",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                fontSize = 32.sp
            )
        )
        Text(
            text = "Silahkan masuk untuk melanjutkan",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 10.dp),
            style = TextStyle(
                color = Color.Gray,
                fontSize = 16.sp
            )
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(modifier = Modifier.padding(16.dp)) {
            CustomOutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email"
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomOutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = "Kata Sandi",
                isPassword = true
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            PrimaryButton(
                text = "MASUK",
                onClick = {
                    loginViewModel.login(email, password)
                    isButtonClicked = true

                    //Navigasi ke HomeActivity
                    navController.navigate(Routes.Home.route)
                },
                icon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Ikon Panah",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
            )
        }

        // Display the email and password if the button was clicked
        if (isButtonClicked) {
            Text(
                text = "Email: ${loginViewModel.loginRequest?.email ?: ""}",
                style = TextStyle(fontSize = 16.sp)
            )
            Text(
                text = "Kata Sandi: ${loginViewModel.loginRequest?.password ?: ""}",
                style = TextStyle(fontSize = 16.sp)
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Belum punya akun?", color = Color.Gray)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Daftar",
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    // Navigasi ke SignUpActivity
                    navController.navigate(Routes.SignUp.route)
                }
            )
        }
    }
}

// Preview for the LoginContent
@Preview(showBackground = true)
@Composable
fun PreviewLoginContent() {
    LoginContent(LoginViewModel(), navController = rememberNavController())
}
