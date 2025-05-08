package com.jpcompose.jpcomposegitsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jpcompose.jpcomposegitsample.ui.theme.JpComposeGitSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        enableEdgeToEdge()
        setContent {
            JpComposeGitSampleTheme {
                Greeting(
                    helloMessage = context.getString(R.string.hello_message),
                    downloadMessage = context.getString(R.string.download_message)
                )
            }
        }
    }
}

@Composable
fun Greeting(helloMessage: String, downloadMessage: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(9.dp)
            .border(width = 1.dp, color = Color.Blue)
            .padding(30.dp)
            .border(width = 4.dp, color = Color.Red)
    ) {
        Text(
            text = helloMessage,
            modifier = modifier
                .padding(top = 9.dp, bottom = 9.dp, start = 10.dp, end = 2.dp),
            fontSize = 20.sp,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough,
                )
            ),
            fontStyle = FontStyle.Italic,
            color = Color.Red
        )
        Text(
            text = downloadMessage,
            modifier = modifier
                .padding(bottom = 4.dp, start = 4.dp, end = 4.dp),
            fontSize = 8.sp
        )
        Image(
            modifier = modifier.width(120.dp),
            painter = painterResource(R.drawable.ic_trees),
            contentDescription = "trees"
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_10)
@Composable
fun GreetingPreview() {
    JpComposeGitSampleTheme {
        Greeting("Android", "Download")
    }
}