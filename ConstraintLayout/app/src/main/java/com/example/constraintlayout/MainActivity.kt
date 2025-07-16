package com.example.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.constraintlayout.ui.theme.ConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConstraintLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LearnConstraintLayout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LearnConstraintLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (redButton, greenButton, blueButton, blackButton) = createRefs()

        Button(
            onClick = {}, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            modifier = Modifier.constrainAs(redButton) {
                top.linkTo(parent.top)
//                width = Dimension.value(300.dp)
                width = Dimension.matchParent
                height = Dimension.wrapContent
            }
        ) {
            Text(text = "Red")
        }
        Button(
            onClick = {}, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.White
            ),
            modifier = Modifier.constrainAs(greenButton) {
                top.linkTo(redButton.bottom)
            }
        ) {
            Text(text = "Green")
        }
        Button(
            onClick = {}, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            modifier = Modifier.constrainAs(blueButton) {
                top.linkTo(redButton.bottom)
            }
        ) {
            Text(text = "Blue")
        }
        createHorizontalChain(greenButton, blueButton, chainStyle = ChainStyle.Packed)

        val guideLine = createGuidelineFromBottom(0.01f)

        Button(
            onClick = {}, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            modifier = Modifier.constrainAs(blackButton) {
//                top.linkTo(blueButton.bottom)
                bottom.linkTo(guideLine)
            }
        ) {
            Text(text = "Black")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayoutTheme {
        LearnConstraintLayout()
    }
}