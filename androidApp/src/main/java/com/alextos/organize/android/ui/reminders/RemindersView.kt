package com.alextos.organize.android.ui.reminders

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alextos.organize.domain.Reminder
import com.alextos.organize.presentation.RemindersViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@Composable
fun RemindersView(
    viewModel: RemindersViewModel = getViewModel(),
    onAboutButtonClick: () -> Unit,
) {
    Column {
        Toolbar(title = viewModel.title, onAboutButtonClick = onAboutButtonClick)
        ContentView(viewModel = viewModel)
    }
}

@Composable
private fun Toolbar(
    title: String,
    onAboutButtonClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(
                onClick = onAboutButtonClick,
                modifier = Modifier.semantics { contentDescription = "aboutButton" }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button",
                )
            }
        }
    )
}

@Composable
private fun ContentView(viewModel: RemindersViewModel) {
    var textFieldValue by remember { mutableStateOf("") }
    var reminders by remember {
        mutableStateOf(listOf<Reminder>(), policy = neverEqualPolicy())
    }

    viewModel.onRemindersUpdated = { reminders = it }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = reminders) { item ->
            val onItemClick = {
                viewModel.markReminder(id = item.id, isCompleted = !item.isCompleted)
            }

            ReminderItem(
                title = item.title,
                isCompleted = item.isCompleted,
                modifier = Modifier.fillMaxWidth()
                    .clickable(enabled = true, onClick = onItemClick)
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }

        item {
            val onSubmit = {
                viewModel.createReminder(title = textFieldValue)
                textFieldValue = ""
            }

            NewReminderTextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                onSubmit = onSubmit,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
private fun ReminderItem(
    title: String,
    isCompleted: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        RadioButton(
            selected = isCompleted,
            onClick = null
        )

        Text(
            text = title,
            style = if (isCompleted) {
                MaterialTheme.typography.body1.copy(
                    textDecoration = TextDecoration.LineThrough,
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray,
                )
            } else {
                MaterialTheme.typography.body1
            },
            modifier = Modifier.padding(8.dp),
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun NewReminderTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text("Add a new reminder here") },
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Words,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(
            onDone = { onSubmit() }
        ),
        modifier = modifier
            .onPreviewKeyEvent { event: KeyEvent ->
                if (event.key == Key.Enter) {
                    onSubmit()
                    return@onPreviewKeyEvent true
                }
                false
            }
    )
}

@Preview(showBackground = true)
@Composable
private fun RemindersViewPreview() {
    RemindersView {
    }
}