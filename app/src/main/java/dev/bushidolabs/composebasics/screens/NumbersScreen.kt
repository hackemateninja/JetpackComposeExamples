package dev.bushidolabs.composebasics.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bushidolabs.composebasics.ui.theme.ComposeBasicsTheme

@Composable
fun NumbersScreen(
  modifier: Modifier = Modifier,
  names: List<String> = listOf("World", "Compose", "elixir", "phoenix", "ecto")
){
  Surface(
    modifier = modifier,
    color = MaterialTheme.colorScheme.background
  ) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
      for (name in names) {
        Greeting(name = name)
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  var expanded by remember { mutableStateOf(false) }
  Surface(
    color = MaterialTheme.colorScheme.primary,
    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
  ) {
    Row(modifier = Modifier.padding(24.dp)){
      Column(
        modifier = Modifier
          .weight(1f)
          .padding(bottom = if (expanded) 48.dp else 0.dp)
      ) {
        Text("hello,")
        Text("$name")
      }
      ElevatedButton(onClick = { expanded = !expanded }) {
        Text(if(expanded) "Show less" else "Show more")
      }
    }
  }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun PreviewNumbersScreen(){
  ComposeBasicsTheme {
    NumbersScreen()
  }
}