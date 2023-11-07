package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.Black
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.Line
import com.example.jetpackcompose.ui.theme.Rubik
import com.example.jetpackcompose.ui.theme.White
import com.example.jetpackcompose.ui.theme.customBorderStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxContainer(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxContainer(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        var text = remember {
            mutableStateOf("")
        }
        Column(modifier = Modifier.wrapContentSize()) {

            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Text(
                    text = "5:13 PM",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(top = 12.dp, start = 16.dp, bottom = 12.dp),
                    fontSize = 18.sp
                )
                Row(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .wrapContentSize()
                        .align(Alignment.CenterEnd)
                ) {
                    Icon(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        painter = painterResource(id = R.drawable.watch),
                        contentDescription = "image watch"
                    )
                    Icon(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        painter = painterResource(id = R.drawable.bluetooth),
                        contentDescription = "image bluetooth"
                    )
                    Icon(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        painter = painterResource(id = R.drawable.wifi),
                        contentDescription = "image wifi"
                    )
                    Icon(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        painter = painterResource(id = R.drawable.signal),
                        contentDescription = "image signal"
                    )
                    Icon(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        painter = painterResource(id = R.drawable.battery),
                        contentDescription = "image battery"
                    )
                }
            }

            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Новая запись",
                fontSize = 30.sp,
                fontFamily = Rubik,
                fontWeight = FontWeight.Bold
            )

            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Icon(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .width(25.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.cross),
                    contentDescription = "image battery"
                )
                Icon(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .align(Alignment.CenterEnd)
                        .width(25.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.swoosh),
                    contentDescription = "image battery"
                )
            }

            OutlinedTextField(modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight().border(width = 3.dp , color = Color.Black, shape = RoundedCornerShape(15.dp)),
                value = text.value,
                onValueChange = { text.value = it },
                label = {
                    Text(
                        text = "Введите запись"
                    )
                }, colors = TextFieldDefaults.textFieldColors(textColor = Color.Gray, containerColor = White),shape = RoundedCornerShape(15.dp)
            )
        }

        Button(modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .height(50.dp)
            .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Line),
            onClick = { }, elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp)
        ) {
            Text(text = "Сохранить", fontSize = 20.sp, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        BoxContainer(
            modifier = Modifier
                .fillMaxSize()
                .background(color = White)
        )
    }
}