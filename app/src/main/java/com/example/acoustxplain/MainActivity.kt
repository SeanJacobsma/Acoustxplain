package com.example.acoustxplain

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.acoustxplain.ui.theme.AcoustxplainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.egg_test)
            val description = "This is an egg"
            val title = "It's an egg loser"
            AcoustxplainTheme {
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp)) {

                    ImageCard(
                        painter = painter,
                        contentDescription = description,
                        title = title)

                }
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier) {

    Card(modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation =  5.dp) {

        Box(modifier = Modifier.height(200.dp)) {

            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop)

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                ))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), 
                contentAlignment = Alignment.BottomStart) {

                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Hello")
        Text(text = "$name!")
    }

}

@Preview(showBackground = true, widthDp = 540, name="light mode")
@Preview(uiMode= Configuration.UI_MODE_NIGHT_YES,showBackground = true, widthDp = 540, name="dark mode")
@Composable
fun DefaultPreview() {
    val painter = painterResource(id = R.drawable.egg_test)
    val description = "This is an egg"
    val title = "It's an egg dummy"
    AcoustxplainTheme {
//        Greeting("Android")
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.50f)
                    .padding(16.dp)) {

                ImageCard(painter = painter, contentDescription = description, title = title)
            }
        }
    }
}