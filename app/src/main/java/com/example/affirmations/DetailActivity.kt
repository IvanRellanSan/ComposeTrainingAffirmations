package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.affirmations.components.DetailComponent
import com.example.affirmations.ui.components.TopBar
import com.example.affirmations.ui.theme.AffirmationsTheme
import com.example.affirmations.ui.viewmodel.DetailViewModel

class DetailActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        var itemId = ""
        intent.extras?.let {
            itemId = it.getString("id")!!
        }

        setContent {
            // TODO 5. Show screen
            val detailViewModel = DetailViewModel()
            detailViewModel.loadItem(itemId)
            DetailScreen(detailViewModel)
        }
    }
}

@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel
) {
    val affirmation by detailViewModel.affirmationState.collectAsState()
    AffirmationsTheme{
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopBar()
            }
        ) {
            affirmation?.let {
                DetailComponent(affirmation = it)
            }
        }
    }
}