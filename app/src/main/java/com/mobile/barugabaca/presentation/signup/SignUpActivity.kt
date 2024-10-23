package com.mobile.barugabaca.presentation.signup

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarugaBacaTheme {
               MyAppNavigation()
            }
        }

    }
}

@Composable
fun SignUpContent(navController: NavController){
    // State untuk email dan password
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var fullname by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Daftar",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                fontSize = 32.sp
            )
        )

        Text(
            text="Silahkan daftar untuk melanjutkan",
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
                value = fullname,
                onValueChange = {},
                label = "Nama Lengkap"
            )

            Spacer(modifier = Modifier.height(16.dp))
            CustomOutlinedTextField(
                value = email,
                onValueChange = {},
                label = "Email"
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomOutlinedTextField(
                value = password,
                onValueChange = {},
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
                text="DAFTAR",
                onClick = {
                    //Logikanya sebelum pindah halaman ke home

                    ////Navigasi ke LoginActivity
                    navController.navigate(Routes.Login.route)
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

        Spacer(modifier = Modifier.height(80.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Sudah punya akun?", color = Color.Gray)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Masuk",
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    ////Navigasi ke LoginActivity
                    navController.navigate(Routes.Login.route)

                }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpContent() {
    SignUpContent(navController = rememberNavController())
}
