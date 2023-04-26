package com.kykint.paintagram.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kykint.paintagram.compose.LoginScreen
import com.kykint.paintagram.ui.theme.PaintagramTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaintagramTheme {
                LoginScreen(
                    onLoginClicked = {
                        startActivity(Intent(this, FeedActivity::class.java))
                    }
                )
                /*
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
                */
            }
        }
    }
}