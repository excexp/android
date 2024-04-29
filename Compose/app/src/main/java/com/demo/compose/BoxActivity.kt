package com.demo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxPreview()
        }
    }
}

@Preview
@Composable
fun BoxPreview() {

    Box(
        Modifier
            .background(Color.Red)
            .size(300.dp)
    ) {
        Box(
            Modifier
                .background(Color.Green)
                .size(250.dp),
            Alignment.BottomStart
        ) {
            Box(
                Modifier
                    .padding(10.dp)
                    .background(Color.Blue)
                    .size(150.dp)
                    .padding(10.dp)
            ) {
                Box(
                    Modifier
                        .background(Color.White)
                        .size(50.dp)
                )
            }
        }
    }
}