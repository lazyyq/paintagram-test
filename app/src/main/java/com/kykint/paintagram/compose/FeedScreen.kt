package com.kykint.paintagram.compose

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.kykint.paintagram.R
import com.kykint.paintagram.ui.theme.PaintagramTheme
import com.kykint.paintagram.viewmodel.IFeedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    viewModel: IFeedViewModel,
    onIdChanged: (String) -> Unit = {},
    onPwChanged: (String) -> Unit = {},
    onLoginClicked: () -> Unit = {},
) {
    Scaffold { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            LazyColumn() {
                itemsIndexed(viewModel.feedModels) { index, item ->
                    FeedItemCard(item)
                }
            }
        }
    }
}

@Preview
@Composable
fun FeedScreenPreview() {
    PaintagramTheme {
        FeedScreen(
            viewModel = object : IFeedViewModel() {
                override val feedModels: List<FeedModel> = listOf(
                    FeedModel(userName = "User 1"),
                    FeedModel(userName = "User 2"),
                    FeedModel(userName = "User 3"),
                )
            }
        )
    }
}

@Composable
fun FeedItemCard(
    model: IFeedViewModel.FeedModel
) {
    Card(
        modifier = Modifier.fillMaxWidth(),

    ) {
        Row {
            model.userIcon?.let {
                Image(it.asImageBitmap(), "")
            }
            Text(model.userName)
        }
    }
}

@Preview
@Composable
fun FeedItemCardPreview() {
    FeedItemCard(
        model = IFeedViewModel.FeedModel(
            userIcon = BitmapFactory.decodeResource(LocalContext.current.resources, android.R.drawable.stat_notify_error),
            userName = "User 1"
        ),
    )
}
