package com.demo.compose.navigation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val plantId: String = savedStateHandle.get<String>("plantId")!!

    // mock data for query database
    val plant = if (plantId == "1") {
        Plant("1", "Daisy")
    } else {
        Plant("2", "Rose")
    }
}

@Composable
fun PlantDetailsScreen(
    plantDetailsViewModel: PlantDetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onShareClick: (String) -> Unit,
    onGalleryClick: (Plant) -> Unit,
) {
    val plant = plantDetailsViewModel.plant



    Column {
        Text("Plant Details",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)

        Text(text = plant.plantId)
        Text(text = plant.name)

        Button(onClick = { onBackClick() }) {
            Text("Back")
        }

        Button(onClick = { onGalleryClick(plant) }) {
            Text("Gallery")
        }

        Button(onClick = { onShareClick(plant.name) }) {
            Text("Share")
        }
    }
}



