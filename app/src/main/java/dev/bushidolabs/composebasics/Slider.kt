package dev.bushidolabs.composebasics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MySlider() {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    var position by remember { mutableStateOf(2f) }
    var finalPosition by remember{ mutableStateOf(position.toInt()) }
    Slider(
      value = position,
      onValueChange = {position = it},
      onValueChangeFinished = {finalPosition = position.toInt()},
      valueRange = 0f..10f,
      steps = 9
    )
    Text(text =  "Selected value: $finalPosition", fontSize = 20.sp, fontStyle = FontStyle.Italic)
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyRangeSlider() {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    var position by remember { mutableStateOf(0f..10f) }
    RangeSlider(
      value = position,
      onValueChange = {position = it},
      valueRange = 0f..10f,
    )
    Text(text =  "Start value: ${position.start}", fontSize = 20.sp, fontStyle = FontStyle.Italic)
    Text(text =  "End value: ${position.endInclusive}", fontSize = 20.sp, fontStyle = FontStyle.Italic)
  }
}