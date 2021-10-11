package com.ondev.noteapp.ui.views

import InputForm
import NoteApp
import NoteCard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ondev.noteapp.data.local.model.NoteEntity
import com.ondev.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NoteApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowNoteCard() {

}

@Preview(showBackground = true)
@Composable
fun ShowNoteInputForm() {

    InputForm(modifier = Modifier.fillMaxSize())

}