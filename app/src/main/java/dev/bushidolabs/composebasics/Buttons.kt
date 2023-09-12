package dev.bushidolabs.composebasics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyButton() {
  var enable by rememberSaveable { mutableStateOf(true) }
  Column(Modifier.fillMaxSize()) {
    Button(
      onClick = { enable = false},
      enabled = enable,
      colors = ButtonDefaults.buttonColors(
        contentColor = Color.Blue,
        containerColor = Color.Magenta,
      ),
      border = BorderStroke(5.dp, Color.Green),
    ) {
      Text("Haz click")
    }
    OutlinedButton(onClick = { /*TODO*/ }) {
      Text("Otro button")
    }
    TextButton(onClick = { /*TODO*/ }) {
      Text("Otro button")
    }
  }
}