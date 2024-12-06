package com.example.kotlintraining03

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Button(
                onClick = { navController.navigate("details") },
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(text = "Go to Details")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("profile") }
            ) {
                Text(text = "Go to Profile")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("background_padding") }
            ) {
                Text(text = "Background and Padding")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("border_shape") }
            ) {
                Text(text = "Border and Shape")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("shadow_clip") }
            ) {
                Text(text = "Shadow and Clip")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("offset_rotate") }
            ) {
                Text(text = "Offset and Rotate")
            }
        }
    }
}