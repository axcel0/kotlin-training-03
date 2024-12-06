package com.example.kotlintraining03

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(navController: NavHostController, goToDestination: String) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Profile Screen",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(text = "Pop Back Stack")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate(goToDestination) }
            ) {
                Text(text = "Go to $goToDestination")
            }
        }
    }
}