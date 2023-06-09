package com.alextos.organize.android.ui.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alextos.organize.presentation.AboutViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AboutView(
    viewModel: AboutViewModel = getViewModel(),
    onUpButtonClick: () -> Unit
) {
    Column {
        Toolbar(title = viewModel.title, onUpButtonClick = onUpButtonClick)
        ContentView(
            items = viewModel.items,
            footer = "This page was first opened\n${viewModel.firstOpening}"
        )
    }
}

@Composable
private fun Toolbar(
    title: String,
    onUpButtonClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Up Button",
                )
            }
        }
    )
}

@Composable
private fun ContentView(
    items: List<AboutViewModel.RowItem>,
    footer: String?
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .semantics { contentDescription = "aboutView" }
    ) {
        items(items) { row ->
            RowView(title = row.title, subtitle = row.subtitle)
        }
        footer?.let {
            item {
                Text(
                    text = it,
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
private fun RowView(
    title: String,
    subtitle: String,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.caption,
                color = Color.Gray
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.body1
            )
        }
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutPreview() {
    AboutView {
    }
}