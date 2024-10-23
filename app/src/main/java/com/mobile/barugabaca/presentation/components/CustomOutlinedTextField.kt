package com.mobile.barugabaca.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.barugabaca.ui.theme.PrimaryColor

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange:(String) -> Unit,
    label:String,
    isPassword:Boolean = false,
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PrimaryColor,
            focusedLabelColor = PrimaryColor,
            cursorColor = PrimaryColor
        ),
        visualTransformation = if (isPassword) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    )
}

@Preview(showBackground = false)
@Composable
fun PreviewCustomOutlinedTextField(){

    //Data dummy
    val email = remember { "admin@gmail.com" }
    val password = remember { "admin123" }

    Column(modifier = Modifier.padding(16.dp)) {
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
}