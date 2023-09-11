package dev.bushidolabs.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dev.bushidolabs.composebasics.ui.theme.ComposeBasicsTheme
import dev.bushidolabs.composebasics.screens.OnboardingScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeBasicsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
          OnboardingScreen()
        }
      }
    }
  }
}


