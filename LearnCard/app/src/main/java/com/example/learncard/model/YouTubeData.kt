package com.example.learncard.model

import androidx.annotation.DrawableRes

data class YouTubeData(
    @DrawableRes val thumbnail: Int,
    val videoTitle: String,
    val channelName: String
)
