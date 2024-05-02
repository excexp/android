package com.demo.compose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun HomeScreen(
    onPlantClick: (Plant) -> Unit = {}
) {
    Column (Modifier.fillMaxSize().background(Color.Gray)){
        Text("Home",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)

        Button(onClick = { onPlantClick(Plant("1", "Daisy")) }) {
            Text("Daisy")
        }

        Button(onClick = { onPlantClick(Plant("2", "Rose")) }) {
            Text("Rose")
        }
    }
}

