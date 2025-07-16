package com.example.learnfabbtn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnfabbtn.ui.theme.GreenJC
import com.example.learnfabbtn.ui.theme.LearnFABBtnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnFABBtnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    LearnFAB()
                    LeanExtendedFAB()
                }
            }
        }
    }
}


@Composable
fun LearnFAB(modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Fab btn click", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            containerColor = GreenJC
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
}

@Composable
fun LeanExtendedFAB() {
    val context = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()) {
        ExtendedFloatingActionButton(
            onClick = {
                Toast.makeText(context, "Extended Fab click", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            containerColor = GreenJC
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
            Text(text = "Compose", fontSize = 16.sp, modifier = Modifier.padding(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LearnFABPreview() {
    LeanExtendedFAB()
}