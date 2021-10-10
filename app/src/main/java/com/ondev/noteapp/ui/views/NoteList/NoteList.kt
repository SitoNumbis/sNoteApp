import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.ondev.noteapp.data.local.model.NoteEntity

@Composable
fun NoteList(modifier: Modifier = Modifier, allNotes: State<List<NoteEntity>>) {
    LazyColumn(modifier = modifier) {
        items(allNotes.value) { note ->
            NoteCard(title = note.title, message = note.message)
        }
    }
}