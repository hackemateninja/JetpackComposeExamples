package dev.bushidolabs.composebasics.screens

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bushidolabs.composebasics.R
import dev.bushidolabs.composebasics.data.conversationSample
import dev.bushidolabs.composebasics.models.Message
import dev.bushidolabs.composebasics.ui.theme.ComposeBasicsTheme

@Composable
fun MessageCard(msg: Message) {
  Row(modifier = Modifier.padding(all = 8.dp)) {
    Image(
      painter = painterResource(R.drawable.profile_picture),
      contentDescription = "Contact profile picture",
      modifier = Modifier
        .size(40.dp)
        .clip(CircleShape)
        .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
    )
    Spacer(modifier = Modifier.width(8.dp))
    
    var isExpanded by remember { mutableStateOf(false) }
    val surfaceColor by animateColorAsState(
      if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
      label = ""
    )
    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
      Text(
        text = msg.author,
        color = MaterialTheme.colorScheme.secondary,
        style = MaterialTheme.typography.titleMedium
      )
      Spacer(modifier = Modifier.height(4.dp))
      Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 1.dp,
        color = surfaceColor,
        modifier = Modifier.animateContentSize().padding(1.dp)
      ) {
        Text(
          text = msg.body,
          modifier = Modifier.padding(all = 4.dp),
          maxLines = if (isExpanded) Int.MAX_VALUE else 1,
          style = MaterialTheme.typography.bodyMedium,
        )
      }
    }
  }
}

@Preview(name = "light Mode")
@Preview(
  uiMode = Configuration.UI_MODE_NIGHT_YES,
  showBackground = true,
  name = "Dark mode"
)
@Composable
fun PreviewMessageCard() {
  ComposeBasicsTheme {
    Surface {
      MessageCard(
        msg = Message("Herman", "Please take my hand")
      )
    }
  }
}

@Composable
fun Conversation(messages: List<Message>) {
  LazyColumn {
    items(messages) { message ->
      MessageCard(message)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun PreviewConversation() {
  Conversation(messages = conversationSample)
}