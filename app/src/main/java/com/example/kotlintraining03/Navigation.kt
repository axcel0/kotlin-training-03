package com.example.kotlintraining03

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import kotlinx.coroutines.delay

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("details") { DetailsScreen(navController, "profile") }
        composable("profile") { ProfileScreen(navController, "details") }
        composable("background_padding") { BackgroundAndPaddingScreen() }
        composable("border_shape") { BorderAndColoringShapeScreen() }
        composable("shadow_clip") { ShadowAndClipScreen() }
        composable("offset_rotate") { OffsetAndRotateScreen() }
    }
}

@Composable
fun BackgroundAndPaddingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(MaterialTheme.colorScheme.onPrimary)
        )
    }
}

@Composable
fun ShadowAndClipScreen() {
    var shape by remember { mutableStateOf<Shape>(CircleShape) }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .shadow(8.dp, shape)
                .clip(shape)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .clickable {
                    shape = if (shape == CircleShape) RoundedCornerShape(0.dp) else CircleShape
                }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OffsetAndRotateScreen() {
    var rotation by remember { mutableFloatStateOf(0f) }
    var isLongPressed by remember { mutableStateOf(false) }

    LaunchedEffect(isLongPressed) {
        while (isLongPressed) {
            rotation += 10f
            delay(100) // Adjust the delay as needed
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset(x = 20.dp, y = 20.dp)
                .rotate(rotation)
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .combinedClickable(
                    onClick = {
                        rotation += 22.5f
                    },
                    onLongClick = {
                        isLongPressed = true
                    },
                    onDoubleClick = {
                        isLongPressed = false
                    },
                )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BorderAndColoringShapeScreen() {
    var color by remember { mutableStateOf(Color.Black) }
    var isLongPressed by remember { mutableStateOf(false) }

    LaunchedEffect(isLongPressed) {
        while (isLongPressed) {
            color = Color(
                red = (0..255).random() / 255f,
                green = (0..255).random() / 255f,
                blue = (0..255).random() / 255f
            )
            delay(500) // Adjust the delay as needed
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(2.dp, MaterialTheme.colorScheme.onBackground, shape = RoundedCornerShape(8.dp))
                .background(color)
                .combinedClickable(
                    onClick = {
                        color = if (color == Color.Red) {
                            Color.Green
                        } else {
                            Color.Red
                        }
                    },
                    onLongClick = {
                        isLongPressed = true
                    },
                    onDoubleClick = {
                        isLongPressed = false
                    },
                )
        )
    }
}