package com.example.affirmations

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.affirmations.components.AffirmationList
import com.example.affirmations.components.DetailComponent
import com.example.affirmations.components.TopBar
import com.example.affirmations.data.Datasource
import com.example.affirmations.screens.Detail
import com.example.affirmations.ui.theme.AffirmationsTheme
import com.example.affirmations.ui.viewmodel.DetailViewModel

class DetailActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        var itemId = ""
        if (intent.extras != null){
            itemId = intent.extras!!.getString("id")!!
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
            DetailComponent(affirmation = affirmation!!)
        }
    }
}