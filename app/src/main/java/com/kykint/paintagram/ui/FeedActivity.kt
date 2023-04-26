package com.kykint.paintagram.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kykint.paintagram.compose.FeedScreen
import com.kykint.paintagram.compose.LoginScreen
import com.kykint.paintagram.ui.theme.PaintagramTheme
import com.kykint.paintagram.viewmodel.IFeedViewModel

class FeedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaintagramTheme {
                FeedScreen(viewModel = object: IFeedViewModel() {
                    override val feedModels: List<FeedModel>
                        get() = emptyList()
                })
            }
        }
    }
}