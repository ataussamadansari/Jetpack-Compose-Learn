package com.example.learncard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learncard.model.YouTubeData
import com.example.learncard.ui.theme.LearnCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayYouTubeVideos()
                }
            }
        }
    }
}

@Composable
fun DisplayYouTubeVideos() {
    val videosList = listOf(
        YouTubeData(R.drawable.img_1, "Video Title 1", "Microfinds"),
        YouTubeData(R.drawable.img_2, "Video Title 2", "Android Knowledge"),
        YouTubeData(R.drawable.img_3, "Video Title 3", "Coding Meet"),
        YouTubeData(R.drawable.img_1, "Video Title 4", "Microfinds"),
        YouTubeData(R.drawable.img_2, "Video Title 5", "Microfinds"),
        YouTubeData(R.drawable.img_3, "Video Title 6", "Android Knowledge"),
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(videosList) {
            it -> YouTubeUI(youTubeData = it)
        }
    }

}