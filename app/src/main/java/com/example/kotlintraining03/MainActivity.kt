package com.example.kotlintraining03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.kotlintraining03.ui.theme.KotlinTraining03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTraining03Theme {
                Navigation()
            }
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
        DetailsScreen(rememberNavController(), "profile")
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    KotlinTraining03Theme {
        ProfileScreen(rememberNavController(), "details")
    }
}