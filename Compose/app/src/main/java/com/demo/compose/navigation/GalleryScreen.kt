package com.demo.compose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val plantName: String = savedStateHandle.get<String>("plantName")!!

    val photoUrl = if (plantName == "Rose") {
        "https://img.zcool.cn/community/018aa65864c4dca801219c77ac287c.JPG@720w_1l_2o_100sh.jpg"
    } else {
        "https://img.zcool.cn/community/01cfb359173d19a801216a3ef9a7a3.jpg@720w_1l_2o_100sh.jpg"
    }
}

@Composable
fun GalleryScreen(
    viewModel: GalleryViewModel = hiltViewModel(),
    onPhotoClick: (String) -> Unit,
    onUpClick: () -> Unit,
) {
    Column {
        Text("Gallery",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)

        Text("Plant is ${viewModel.plantName}")
        
        Button(onClick = { onUpClick() }) {
            Text(text = "Back")
        }

        Button(onClick = { onPhotoClick(viewModel.photoUrl) }) {
            Text(text = "Show Photo")
        }
    }

}

