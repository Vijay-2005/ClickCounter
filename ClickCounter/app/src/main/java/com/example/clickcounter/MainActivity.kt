package com.example.clickcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.animation.core.*
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import com.example.clickcounter.ui.theme.ClickCounterTheme
import androidx.compose.material3.CardDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickCounterTheme {
                ClickCounter()
            }
        }
    }
}

@Composable
fun ClickCounter() {
    var count by remember { mutableStateOf(0) }
    var animationProgress by remember { mutableStateOf(0f) }

    // Animation for the count
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFf0f4f7)) // Light background color
            .padding(24.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(8.dp, CircleShape),
            elevation = CardDefaults.cardElevation
                    (defaultElevation = 4.dp) ,

            shape = MaterialTheme.shapes.medium,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "You clicked $count times",
                    style = TextStyle(fontSize = 30.sp, color = Color(0xFF3D5AFE), fontWeight = FontWeight.Bold)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Animated text (count)
                Text(
                    text = "$count",
                    style = TextStyle(fontSize = 60.sp, fontWeight = FontWeight.Bold, color = Color(0xFF6200EE)),
                    modifier = Modifier.scale(scale) // Applying scale animation
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Button with ripple effect and icon
                ElevatedButton(
                    onClick = {
                        count++
                    },
                    shape = CircleShape,
                    modifier = Modifier
                        .size(150.dp)
                        .background(MaterialTheme.colorScheme.primary),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
                    contentPadding = PaddingValues(16.dp),
                    elevation = ButtonDefaults.buttonElevation(8.dp)
                ) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Click Me", tint = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ClickCounterTheme {
        ClickCounter()
    }
}
