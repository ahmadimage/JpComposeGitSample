package com.jpcompose.jpcomposegitsample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
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
                    downloadMessage = context.getString(R.string.download_message),
                    context = context
                )
            }
        }
    }
}

@Composable
fun Greeting(
    helloMessage: String,
    downloadMessage: String,
    modifier: Modifier = Modifier,
    context: Context? = null
) {
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
        BaseImageComposable(modifier)
        BaseButtonComposable(context, modifier)
        BaseTextField(modifier = modifier)
    }
}

@Composable
fun BaseImageComposable(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.width(120.dp),
        painter = painterResource(R.drawable.ic_trees),
        contentDescription = "trees"
    )
}

@Composable
fun BaseButtonComposable(context: Context?, modifier: Modifier = Modifier) {
    Button(
        onClick = {
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
        },
    ) {
        Text("button filled")
    }
    FilledTonalButton (
        onClick = {
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
        },
    ) {
        Text("button tonal")
    }
}

@Composable
fun BaseTextField(modifier: Modifier = Modifier) {

    var text by remember {
        mutableStateOf(TextFieldValue())
    }

    TextField(
        value = text,
        onValueChange = {
            newValue -> text = newValue
        },
        modifier = modifier.width(120.dp),
    )
}

@Preview(showBackground = true, device = Devices.NEXUS_10)
@Composable
fun GreetingPreview() {
    JpComposeGitSampleTheme {
        Greeting("Android", "Download")
    }
}