package dev.bushidolabs.composebasics.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bushidolabs.composebasics.ui.theme.ComposeBasicsTheme

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {
  Column {
    Row {
      RadioButton(selected = name == "Herman", onClick = { onItemSelected("Herman") })
      Text(text = "Herman")
    }
    Row {
      RadioButton(selected = name == "Manuel", onClick = { onItemSelected("Manuel") })
      Text(text = "Manuel")
    }
    Row {
      RadioButton(selected = name == "Steven", onClick = { onItemSelected("Steven") })
      Text(text = "Steven")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MyRadioButtonPreview() {
  var name by rememberSaveable{ mutableStateOf("Herman") }
  Column(Modifier.fillMaxSize()) {
    MyRadioButtonList(name = name, onItemSelected = {name = it})
  }
}

@Composable
fun MyTriStatus() {
  var state by rememberSaveable{ mutableStateOf(ToggleableState.Off) }
  Column(Modifier.fillMaxSize()) {
    TriStateCheckbox(state = state, onClick = {
      state = when (state) {
        ToggleableState.On -> ToggleableState.Off
        ToggleableState.Off -> ToggleableState.Indeterminate
        ToggleableState.Indeterminate -> ToggleableState.On
      }
    })
  }
}

data class CheckInfo(
  val title: String,
  val isChecked: Boolean = false,
  val onCheckedChange: (Boolean) -> Unit
)

@Composable
fun MyCheckBoxWithText(checkInfo: CheckInfo) {
  Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
    Checkbox(checked = checkInfo.isChecked, onCheckedChange = {checkInfo.onCheckedChange(!checkInfo.isChecked)})
    Spacer(Modifier.width(3.dp))
    Text(checkInfo.title)
  }
}


@Composable
fun getOptions(titles: List<String>): List<CheckInfo>{
  return titles.map {
    var isChecked by remember { mutableStateOf(false) }
    CheckInfo(title = it, isChecked = isChecked) { isChecked = it }
  }
}

@Composable
fun MyCheckBoxWithTextPrev() {
  
  val options = getOptions(listOf("Herman", "Manuel", "Steven"))
  ComposeBasicsTheme {
    Column(Modifier.fillMaxSize()) {
      options.map{
        MyCheckBoxWithText(it)
      }
    }
  }
}

@Preview
@Composable
fun MySwitch() {
  var checked by remember{ mutableStateOf(true) }
  Column(Modifier.fillMaxSize()) {
    Switch(
      checked = checked,
      onCheckedChange = {checked = !checked},
      colors = SwitchDefaults.colors(
        uncheckedBorderColor = Color.Green,
        uncheckedThumbColor = Color.Magenta,
        uncheckedIconColor = Color.Cyan,
        uncheckedTrackColor = Color.Black,
        checkedBorderColor = Color.Green,
        checkedThumbColor = Color.Magenta,
        checkedIconColor = Color.Cyan,
        checkedTrackColor = Color.Black,
      )
    )
    Checkbox(
      checked = checked,
      onCheckedChange = {checked = !checked},
      colors = CheckboxDefaults.colors(
        checkedColor = Color.Cyan
      )
    )
  }
}