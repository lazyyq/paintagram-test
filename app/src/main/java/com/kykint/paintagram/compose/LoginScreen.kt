package com.kykint.paintagram.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kykint.paintagram.ui.theme.PaintagramTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
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
            LoginBox(
                onIdChanged = onIdChanged,
                onPwChanged = onPwChanged,
                onLoginClicked = onLoginClicked,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(32.dp),
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    PaintagramTheme {
        LoginScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBox(
    modifier: Modifier = Modifier,
    onIdChanged: (String) -> Unit = {},
    onPwChanged: (String) -> Unit = {},
    onLoginClicked: () -> Unit = {},
) {
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

    Card(
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            // contentColor = MaterialTheme.colorScheme.primary,
        ),
        modifier = modifier,
    ) {
        // ID
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(24.dp),
        ) {
            OutlinedTextField(
                value = id,
                onValueChange = {
                    id = it
                    onIdChanged(it)
                },
                placeholder = { Text("ID") },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = pw,
                onValueChange = {
                    pw = it
                    onPwChanged(it)
                },
                placeholder = { Text("비밀번호") },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(32.dp))
            ElevatedButton(
                onClick = onLoginClicked,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("로그인")
            }
        }
    }
}

@Preview
@Composable
fun LoginBoxPreview() {
    PaintagramTheme {
        LoginBox()
    }
}
