package dev.bushidolabs.composebasics.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun InstagramLoginScreen() {
  //val activity = LocalContext as Activity
  Box(
    Modifier
      .fillMaxSize()
      .padding(8.dp)) {
    LoginHeader(onCloseApp = {})
  }
}

@Composable
fun LoginHeader(onCloseApp: ()->Unit) {
  IconButton(onClick = { onCloseApp() }) {
    Icon(imageVector = Icons.Default.Close, contentDescription = "Close app")
  }
}