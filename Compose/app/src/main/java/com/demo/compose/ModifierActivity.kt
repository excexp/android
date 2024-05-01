package com.demo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ModifierDemo()
        }
    }
}

/**
 * https://developer.android.com/develop/ui/compose/layouts/constraints-modifiers
 */
@Preview
@Composable
fun ModifierDemo() {
    Column {
        Box(
            Modifier
                .size(width = 300.dp, height = 200.dp)
                .background(Color.Red)
        ) {
            Image(
                painterResource(R.drawable.hero),
                contentDescription = null,
                Modifier
                    .fillMaxSize()
                    .size(50.dp)
            )
        }

        Box(
            Modifier
                .size(width = 300.dp, height = 200.dp)
                .background(Color.Green)
        ) {
            Image(
                painterResource(R.drawable.hero),
                contentDescription = null,
                Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    .size(50.dp)
            )
        }

        Box(
            Modifier
                .size(width = 300.dp, height = 200.dp)
                .background(Color.Blue)
        ) {
            Image(
                painterResource(R.drawable.hero),
                contentDescription = null,
                Modifier
                    .clip(CircleShape)
                    .padding(10.dp)
                    .size(100.dp)
            )
        }
    }
}