package dev.bushidolabs.composebasics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun MyFatherComponent() {
  var text by remember { mutableStateOf("") }
  Column(Modifier.fillMaxSize()) {
    MyOutlineTextField(myText = text, onValueChange = {text = it})
    Text("El texto ingresado es: $text")
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOutlineTextField(myText: String, onValueChange:(String) -> Unit) {
  Column(Modifier.fillMaxSize()) {
    
    OutlinedTextField(
      value = myText,
      onValueChange = {onValueChange(it)},
      label = { Text(text = "Introduce tu nombre")},
      colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Magenta,
        unfocusedBorderColor = Color.Green
      )
    )
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
  Column(Modifier.fillMaxSize()) {
    var text by remember { mutableStateOf("") }
    
    TextField(
      value = text,
      onValueChange = {
        text = if(it.contains("a")) it.replace("a", "@") else it
      },
      label = { Text(text = "Introduce tu nombre")}
    )
  }
}


@Composable
fun MyText() {
  Column(Modifier.fillMaxSize()) {
    Text("Hello world")
    Text("Hello world", color = Color.Blue)
    Text("Hello world", fontWeight = FontWeight.Bold)
    Text("Hello world", fontWeight = FontWeight.Light)
    Text("Hello world", style = TextStyle(fontFamily = FontFamily.Cursive))
    Text("Hello world", style = TextStyle(textDecoration = TextDecoration.LineThrough))
    Text("Hello world", style = TextStyle(textDecoration = TextDecoration.Underline))
    Text("Hello world", textDecoration = TextDecoration.combine(
      listOf(TextDecoration.LineThrough, TextDecoration.Underline)
    ))
    Text("Hello world", fontSize = 30.sp, fontFamily = FontFamily.Monospace)
  }
}