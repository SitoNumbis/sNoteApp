import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.ondev.noteapp.SharedViewModel
import com.ondev.noteapp.data.local.model.NoteEntity

@Composable
fun InputForm(modifier: Modifier = Modifier, viewModel: SharedViewModel? = null) {

    val noteTitle = remember {
        mutableStateOf(TextFieldValue())
    }

    val noteMessage = remember {
        mutableStateOf(TextFieldValue())
    }

    Card(modifier = modifier) {

        Row(modifier = Modifier.fillMaxSize(),verticalAlignment = Alignment.Bottom) {
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(8f)) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    value = noteTitle.value,
                    onValueChange = { noteTitle.value = it })
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    value = noteMessage.value,
                    onValueChange = { noteMessage.value = it })
            }

            Button(modifier = Modifier.weight(3f), onClick = {
                val noteNow = NoteEntity(
                    title = noteTitle.value.text,
                    message = noteMessage.value.text,
                    date = System.currentTimeMillis()
                )
                viewModel?.onInsert(noteEntity = noteNow)
            }) {
                Text(text = "Add Note")
            }

        }

    }

}