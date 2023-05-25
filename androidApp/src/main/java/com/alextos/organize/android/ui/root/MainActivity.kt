package com.alextos.organize.android.ui.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alextos.organize.android.ui.theme.AppTheme
import com.alextos.organize.presentation.RemindersViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm: RemindersViewModel = getViewModel()
        setContent {
            AppTheme {
                AppScaffold()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        AppScaffold()
    }
}