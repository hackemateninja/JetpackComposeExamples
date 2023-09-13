package dev.bushidolabs.composebasics.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun MyState() {
  
  var counter by rememberSaveable { mutableStateOf(0) }
  
  Column(
    Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Button(onClick = { counter += 1 }) {
      Text("Haz clic")
    }
    Text("Tu haz hecho click $counter ${if (counter == 1 ) "vez" else "veces"}")
  }
}