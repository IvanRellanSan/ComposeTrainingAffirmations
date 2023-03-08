package com.example.affirmations.ui.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.affirmations.components.AffirmationList
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val dataSource = Datasource()

    private val _listState = MutableStateFlow<List<Affirmation>>(mutableListOf())
    val listState: StateFlow<List<Affirmation>> = _listState.asStateFlow()

    fun loadData(){
        _listState.value = dataSource.loadAffirmations()
    }
}