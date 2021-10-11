import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ondev.noteapp.R
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

    Card(modifier = modifier, elevation = 4.dp) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    placeholder = { Text(text = stringResource(id = R.string.noteTitlePlaceholder)) },
                    label = { Text(text = stringResource(id = R.string.noteTitleLabel)) },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Gray
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(8f),
                    value = noteTitle.value,
                    onValueChange = { noteTitle.value = it })
                IconButton(modifier = Modifier
                    .clip(shape = RoundedCornerShape(20))
                    .background(color = Color.Blue),
                    onClick = {
                        val noteNow = NoteEntity(
                            title = noteTitle.value.text,
                            message = noteMessage.value.text,
                            date = System.currentTimeMillis()
                        )
                        viewModel?.onInsert(noteEntity = noteNow)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add, contentDescription = stringResource(
                            id = R.string.add_note_button
                        )
                    )
                }
            }
            TextField(
                placeholder = { Text(text = stringResource(id = R.string.noteMessagePlaceholder)) },
                label = { Text(text = stringResource(id = R.string.noteMessageLabel)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = noteMessage.value,
                onValueChange = { noteMessage.value = it })
        }
    }
}

@Preview
@Composable
fun PreviewImage() {
    InputForm(modifier = Modifier.fillMaxSize())
}