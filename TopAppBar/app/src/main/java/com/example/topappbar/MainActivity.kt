package com.example.topappbar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.topappbar.ui.theme.GreenJC
import com.example.topappbar.ui.theme.TopAppBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopAppBarTheme {
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnTopAppBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnTopAppBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text(text = "WhatsApp") },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "nav icon click", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    painter = painterResource(R.drawable.whatsapp),
                    contentDescription = "whatsapp logo"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenJC,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
            }
            IconButton(onClick = {
                Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Profile")
            }
            IconButton(onClick = {
                Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Profile")
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    LearnTopAppBar()
}