package com.example.affirmations.ui.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel() : ViewModel() {
    private val _affirmationState = MutableStateFlow<Affirmation?>(null)
    val affirmationState: StateFlow<Affirmation?> = _affirmationState.asStateFlow()

    private val list = Datasource().loadAffirmations()

    fun loadItem(affirmationId: String){
        val affirmation = list.filter { it.id == affirmationId }
        _affirmationState.value = if (affirmation.isEmpty()) {
            null
        } else {
            affirmation[0]
        }
    }
}