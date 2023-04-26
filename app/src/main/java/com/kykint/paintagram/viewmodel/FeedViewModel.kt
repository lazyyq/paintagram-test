package com.kykint.paintagram.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel

abstract class IFeedViewModel: ViewModel() {
    abstract val feedModels: List<FeedModel>

    data class FeedModel(
        val userIcon: Bitmap? = null,
        val userName: String = "Unknown user",
        val pictures: List<Bitmap?> = emptyList()
    )
}