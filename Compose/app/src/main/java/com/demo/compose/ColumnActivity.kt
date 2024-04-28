package com.demo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnPreview()
        }
    }
}


@Preview
@Composable
fun ColumnPreview() {
    Column( Modifier.fillMaxSize() ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .height(100.dp) ) {
        }

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .height(100.dp) ) {
        }

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .height(100.dp) ) {
        }
    }
}

