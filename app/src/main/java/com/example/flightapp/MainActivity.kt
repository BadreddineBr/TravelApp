package com.example.flightapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Color(0xFF6200EE)
                        )
                    }
                },
                actions = {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(45.dp)
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        content = { paddingValues ->
            BookingScreen(modifier = Modifier.padding(paddingValues))
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = Color(0xFFFCFCFC)
            ) {
                IconButton(onClick = { /* TODO: Home action */ }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.weight(1f)) // Adds space between buttons
                IconButton(onClick = { /* TODO: Search action */ }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "briefcase",
                        tint = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.weight(1f)) // Adds space between buttons

                IconButton(onClick = { /* TODO: Home action */ }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "briefcase",
                        tint = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.weight(1f)) // Adds space between buttons

                IconButton(onClick = { /* TODO: Home action */ }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "user",
                        tint = Color.Gray
                    )
                }
            }
        }
    )
}


@Composable
fun BookingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        GreetingSection()
        Spacer(modifier = Modifier.height(16.dp))
        SearchBarWithSettings()
    }
}

@Composable
fun GreetingSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Good Morning, user....",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp,
            color = Color.Gray
        )
        Text(
            text = "Make plan for weekend",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarWithSettings() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 1.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var searchText by remember { mutableStateOf("") }

        TextField(
            value = searchText,

            onValueChange = { searchText = it },
            placeholder = { Text("Search Places") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .weight(1f)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(10.dp)
                ),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )


        Spacer(modifier = Modifier.width(8.dp))

        FloatingActionButton(
            onClick = { /* TODO: Settings action */ },
            containerColor = Color(0xFF6200EE),
            modifier = Modifier.size(56.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.sett),
                contentDescription = "Settings",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    MyApp()
}
