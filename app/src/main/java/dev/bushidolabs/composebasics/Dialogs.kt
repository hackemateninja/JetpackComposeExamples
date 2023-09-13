package dev.bushidolabs.composebasics

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import dev.bushidolabs.composebasics.ui.theme.ComposeBasicsTheme


@Composable
fun MyDialog(show: Boolean, onConfitm:()->Unit, onDismiss:() -> Unit) {
  if (show){
    Dialog(
      onDismissRequest = { onDismiss()},
      properties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
        decorFitsSystemWindows = true,
        usePlatformDefaultWidth = true
      )
    ){
      Column {
        Text(text = "title")
        Text(text = "Description")
      }
    }
  }
}

@Composable
fun MyAlertDialog(show: Boolean, onConfirm:()->Unit, onDismiss:() -> Unit) {
  if(show){
    AlertDialog(
      onDismissRequest = { onDismiss() },
      title = { Text(text = "this is title")},
      text = { Text(text = "this is description")},
      confirmButton = {
        TextButton(onClick = { onConfirm() }) {
          Text(text = "Confirm")
        }
      },
      dismissButton = {
        TextButton(onClick = { onDismiss() }) {
          Text(text = "Dismiss")
        }
      },
    )
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyDialogPreview() {
  
  var show by remember { mutableStateOf(false) }
  
  ComposeBasicsTheme {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      Button(onClick = { show = true }) {
        Text(text = "Open Dialog")
      }
    
      MyAlertDialog(
        show = show,
        onConfirm = {Log.i("hackemate", "This is a confirmation")},
        onDismiss = {show = false}
      )
    }
  }
}