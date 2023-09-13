package dev.bushidolabs.composebasics.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyCard(){
 Card(
   modifier = Modifier
     .fillMaxWidth()
     .padding(16.dp),
   elevation = CardDefaults.cardElevation(12.dp),
   shape = MaterialTheme.shapes.small,
   border = BorderStroke(5.dp, Color.Magenta)
 ) {
  Column(modifier = Modifier.padding(16.dp)) {
    Text(text = "Text 1")
    Text(text = "Text 2")
    MyCustomBadge(badgeText = "100")
  }
 }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCustomBadge(badgeText: String) {
  BadgedBox(
    badge = {
      Badge {
        Text(text = badgeText)
      }
    },
    modifier = Modifier.padding(10.dp),
  ) {
    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "")
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyDropDownMenu() {
  var selectedText by rememberSaveable { mutableStateOf("") }
  var expanded by rememberSaveable { mutableStateOf(false) }
  var meals = listOf("Pan", "pizza", "papas", "carne")
  Column() {
    Column(Modifier.padding(20.dp)) {
      OutlinedTextField(
        value = selectedText,
        onValueChange = {selectedText = it},
        enabled = false,
        readOnly = true,
        modifier = Modifier
          .clickable { expanded = true }
          .fillMaxWidth()
      )
      DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
      ) {
        meals.map {
          DropdownMenuItem(
            text = { Text(text = it) },
            onClick = {
              expanded = false
              selectedText = it
            },
          )
        }
      }
    }
  }
}