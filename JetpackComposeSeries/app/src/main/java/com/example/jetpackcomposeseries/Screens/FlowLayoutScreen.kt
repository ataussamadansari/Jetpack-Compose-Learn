package com.example.jetpackcomposeseries.Screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ✅ 1. Model
data class ChipItem(val text: String)

// ✅ 2. Sample Data List
val listDesserts = listOf(
    ChipItem("Chocolate"),
    ChipItem("Strawberry"),
    ChipItem("Vanilla"),
    ChipItem("Mango"),
    ChipItem("Pineapple"),
    ChipItem("Blueberry"),
    ChipItem("Raspberry"),
    ChipItem("Cookies"),
    ChipItem("Pudding"),
    ChipItem("Cupcake")
)


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutScreen(modifier: Modifier = Modifier) {
    FlowRow (
        Modifier
            .padding(20.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        repeat(listDesserts.size) {
            Box(
                Modifier
                    .fillMaxRowHeight()
                    .border(1.dp, Color.DarkGray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {

                Text(
                    text = listDesserts[it].text,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(3.dp)
                )
            }
        }
    }
}
