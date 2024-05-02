package com.demo.compose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun HomeScreen(
    onPlantClick: (Plant) -> Unit = {}
) {
    Column (Modifier.fillMaxSize().background(Color.Gray)){
        Text("Home")
        Button(onClick = { onPlantClick(Plant("1", "sunflower")) }) {
            Text("Sunflower")
        }

        Button(onClick = { onPlantClick(Plant("2", "rose")) }) {
            Text("Rose")
        }
    }
}

