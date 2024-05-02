package com.demo.compose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun PlantDetailsScreen(
    plantDetailsViewModel: PlantDetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onShareClick: (String) -> Unit,
    onGalleryClick: (Plant) -> Unit,
) {
    val plantId = plantDetailsViewModel.plantId

    Column {
        Text(text = plantId)

        Button(onClick = { onBackClick() }) {
            Text("Back")
        }
    }
}



