package com.example.m3drawerjc.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.m3drawerjc.R

@Composable
fun NavBarHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "logo",
            modifier = Modifier
                .size(100.dp)
        )
        Text(
            text = "Samad",
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun NavBarBody(
    items: List<NavigationItem>,
    currentRoute: String?,
    onClick: (NavigationItem) -> Unit
) {

    items.forEachIndexed { index, item ->
        NavigationDrawerItem(
            label = {
                Text(text = item.title)
            },
            selected = currentRoute == item.route,
            onClick = { onClick(item) },
            icon = {
                Icon(
                    imageVector = if (currentRoute == item.route) item.selectedIcon else item.unselectedIcon,
                    contentDescription = item.title
                )
            },
            badge = {
                item.badgeCount?.let {
                    Text(text = it.toString())
                }
            },
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        )
    }
}