package dev.bushidolabs.composebasics.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bushidolabs.composebasics.data.navigationList
import dev.bushidolabs.composebasics.ui.theme.ComposeBasicsTheme

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text("Welcome to the Compose examples")
    for (screen in navigationList){
      Button(
        modifier = Modifier.padding(vertical = 24.dp),
        onClick = { /*TODO*/ }
      ) {
        Text(screen)
      }
    }
  }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
private fun PreviewOnboardingScreen(){
  ComposeBasicsTheme {
    OnboardingScreen()
  }
}