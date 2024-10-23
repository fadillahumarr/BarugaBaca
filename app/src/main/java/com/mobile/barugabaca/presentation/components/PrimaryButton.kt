package com.mobile.barugabaca.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.barugabaca.ui.theme.PrimaryColor

@Composable
fun PrimaryButton(
    text:String,
    onClick:()-> Unit,
    icon: @Composable (()-> Unit)? = null,
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(50.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),

        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = text,
                color = Color.White
            )
            icon?.invoke()
            if(icon != null){
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewPrimaryButton(){
    PrimaryButton(
        text="MASUK",
        onClick = {},
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

