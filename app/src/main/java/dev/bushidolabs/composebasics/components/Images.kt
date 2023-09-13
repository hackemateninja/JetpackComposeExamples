package dev.bushidolabs.composebasics.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bushidolabs.composebasics.R

@Preview(showBackground = true)
@Composable
fun MyImage() {
  Column(Modifier.fillMaxSize()) {
    Image(
      painter = painterResource(id = R.drawable.ic_launcher_background),
      contentDescription = "Profile picture",
    )
    Image(
      painter = painterResource(id = R.drawable.profile_picture),
      contentDescription = "Profile picture",
      Modifier.alpha(0.5f)
    )
    Image(
      painter = painterResource(id = R.drawable.profile_picture),
      contentDescription = "Profile picture",
      Modifier
        .clip(CircleShape)
        .border(5.dp, Color.Red, CircleShape)
    )
    Icon(imageVector = Icons.Outlined.AccountBox, tint = Color.Blue, contentDescription = "simple icon")
  }
}