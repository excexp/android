package com.demo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextPreview()
        }
    }
}

@Preview
@Composable
fun TextPreview() {

    Column {
        SimpleText()

        StringResourceText()

        BlueText()

        BigText()

        TextShadow()

        MultipleStylesInText()

        BasicMarqueeSample()
    }
}

@Composable
fun SimpleText() {
    Text("Hello World")
}

@Composable
fun StringResourceText() {
    Text(stringResource(R.string.app_name))
}

@Composable
fun BlueText() {
    Text("Hello World", color = Color.Blue)
}

@Composable
fun BigText() {
    Text("Hello World", fontSize = 30.sp)
}

@Composable
fun ItalicText() {
    Text("Hello World", fontStyle = FontStyle.Italic)
}

@Composable
fun TextShadow() {
    val offset = Offset(5.0f, 8.0f)
    Text(
        text = "Hello world!",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue, offset = offset, blurRadius = 3f
            )
        )
    )
}

@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasicMarqueeSample() {
    // Marquee only animates when the content doesn't fit in the max width.
    Column(Modifier.width(400.dp)) {
        Text(
            "Learn about why it's great to use Jetpack Compose",
            modifier = Modifier.basicMarquee(),
            fontSize = 50.sp
        )
    }
}