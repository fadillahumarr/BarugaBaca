package com.mobile.barugabaca.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.barugabaca.R
import com.mobile.barugabaca.ui.theme.BarugaBacaTheme
import com.mobile.barugabaca.ui.theme.PrimaryColor
import com.mobile.barugabaca.ui.theme.SecondaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BarugaBacaTheme {
                HomeContent()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(){
    var searchQuery by remember { mutableStateOf("") }

    val popularBooks = listOf(
        Book("Book 1", R.drawable.buku1), // Use actual image resource
        Book("Book 2", R.drawable.buku2),
        Book("Book 3", R.drawable.buku3),
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 32.dp, horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Icon Location",
                    modifier = Modifier.size(24.dp),
//                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Jl. Poros Malino",
                    style = TextStyle (
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp
                    )
                )
            }
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Icon Notification",
                modifier = Modifier.size(24.dp),
//                tint = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(
                    width = 1.dp,
                    color = PrimaryColor,
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.CenterStart,

        ) {
            Row(
                modifier = Modifier.padding(vertical=1.dp, horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Cari perpustakaan, buku", color = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF0A946))
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Sudah buat anggota perpustakaan?",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = { /* NANTI DIURUS */ },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C3D2E))
                    ) {
                        Text(
                            text = "Buat kartu",
                            style = TextStyle(
                                fontSize = 12.sp,
                            ),
                            color = Color.White
                        )
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.perpustakaan),
                    contentDescription = null,
                    modifier = Modifier
                        .width(160.dp)
                        .align(Alignment.Bottom)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween,
           verticalAlignment = Alignment.CenterVertically
       ){
           Text(
               text = "Buku Populer",
               style = MaterialTheme.typography.titleSmall,
               modifier = Modifier.padding(bottom = 8.dp)
           )
           Text(
               text = "Lihat Selengkapnya"

           )
       }
        PopularBooksList(books = popularBooks)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Buku lainnya",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Box(){
            Row(){
                Image(
                    painter = painterResource(R.drawable.buku1),
                    contentDescription = "Book Cover"
                )
                Column(){
                    Text(
                        text = "Pulang",
                        style = TextStyle(
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Medium,
                            color = SecondaryColor
                        )
                    )
                    Text(
                        text = "Karya Tere Liye",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = SecondaryColor
                        )
                    )
                    HorizontalDivider(
                        color = SecondaryColor,
                        thickness = 1.dp
                    )
                    Text(
                        text = "Kisah ini bermula ketika Bujang, seorang anak berusia 15 tahun yang memiliki kemampuan hebat dalam berburu babi hutan dapat membuat Teuke Muda terkesan dan akhirnya membawanya ke Kota untuk diasuh seperti layaknya anak angkat.",
                        style = TextStyle(
                            fontSize = 10.sp,
                        )
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = {
                                //Harus buat logicnya untuk hubungkan dengan database sebelum masuk ke halaman home atau main activity

                            },
                            modifier = Modifier
                                .height(50.dp),
                            shape = MaterialTheme.shapes.extraLarge,
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                        ) {
                            Text(
                                text = "Dipinjam"
                            )
                        }
                    }
                }
            }

        }

    }

}

// Model class for Book
data class Book(val title: String, val imageRes: Int)

// PopularBooksList with LazyRow to create a scrollable row of books
@Composable
fun PopularBooksList(books: List<Book>) {
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        items(books) {book ->
            BookItem(book)
        }
    }
}

// Each individual book item
@Composable
fun BookItem(book: Book) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .size(200.dp, 250.dp)
    ) {
        Image(
            painter = painterResource(id = book.imageRes),
            contentDescription = "Book Cover",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}








@Preview(showBackground = true)
@Composable
fun PreviewHomeContent() {
    HomeContent()
}