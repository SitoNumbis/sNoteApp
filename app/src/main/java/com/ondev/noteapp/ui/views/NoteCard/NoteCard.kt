import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun NoteCard(title: String, message: String) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            Modifier
                .padding(8.dp),
        ) {
            Text(text = title, overflow = TextOverflow.Ellipsis, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = message,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
                maxLines = 3
            )

        }
    }
}