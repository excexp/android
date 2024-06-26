package com.demo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class RowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowPreview()
        }
    }
}


@Preview
@Composable
fun RowPreview() {
    Row(Modifier.fillMaxSize()) {
        Surface(
            color = Color.Red,
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
        ) {
        }

        Surface(
            color = Color.Green,
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
        ) {
        }

        Surface(
            color = Color.Blue,
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
        ) {
        }

    }
}

