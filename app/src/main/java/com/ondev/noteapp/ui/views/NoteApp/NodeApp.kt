
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ondev.noteapp.SharedViewModel
import com.ondev.noteapp.ui.views.InputForm
import com.ondev.noteapp.ui.views.NoteList

@Composable
fun NoteApp(
    viewModel: SharedViewModel = hiltViewModel()
) {

    val allNotes = viewModel.allNotes.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        NoteList(
            allNotes = allNotes, modifier = Modifier
                .fillMaxSize()
                .weight(8f)
        )
        InputForm(
            modifier = Modifier
                .fillMaxSize()
                .weight(4f), viewModel
        )
    }
}