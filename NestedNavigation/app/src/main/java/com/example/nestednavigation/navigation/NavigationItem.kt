package com.example.nestednavigation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasBadgeDot: Boolean = false,
    val badgeCount: Int? = null
)