package com.example.kotlintraining03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.lifecycle.*
import androidx.lifecycle.compose.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.kotlintraining03.ui.theme.KotlinTraining03Theme
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTraining03Theme {
                Navigation()
                LifecycleExample()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("details") { DetailsScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
    }
}

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
        }
    }
}

@Composable
fun DetailsScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Details Screen",
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
                onClick = { navController.navigate("home") }
            ) {
                Text(text = "Go to Home")
            }
        }
    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
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
                onClick = { navController.navigate("home") }
            ) {
                Text(text = "Go to Home")
            }
        }
    }
}

@Composable
fun LifecycleExample() {
    val lifecycleOwner = LocalLifecycleOwner.current
    var popBackStackCount by remember { mutableIntStateOf(0) }
    var goToHomeCount by remember { mutableIntStateOf(0) }
    val currentOnStart by rememberUpdatedState {
        // Increment popBackStackCount onStart
        popBackStackCount++
        println("LifecycleExample: onStart - Pop Back Stack Count: $popBackStackCount")
    }
    val currentOnStop by rememberUpdatedState {
        // Increment goToHomeCount onStop
        goToHomeCount++
        println("LifecycleExample: onStop - Go to Home Count: $goToHomeCount")
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> currentOnStart()
                Lifecycle.Event.ON_STOP -> currentOnStop()
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    // Center the content on the screen
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Pop Back Stack Count: $popBackStackCount")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Go to Home Count: $goToHomeCount")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KotlinTraining03Theme {
        HomeScreen(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    KotlinTraining03Theme {
        DetailsScreen(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    KotlinTraining03Theme {
        ProfileScreen(rememberNavController())
    }
}