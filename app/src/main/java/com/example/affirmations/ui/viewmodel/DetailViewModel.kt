package com.example.affirmations.ui.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(id: String) : ViewModel() {
    private val affirmationId: String = id

    private val _affirmationState = MutableStateFlow<Affirmation?>(null)
    val affirmationState: StateFlow<Affirmation?> = _affirmationState.asStateFlow()

    init{
        loadItem()
    }

    @VisibleForTesting
    fun loadItem(){
        val affirmations = Datasource().loadAffirmations()
        for (item in affirmations){
            if (item.id == affirmationId){
                _affirmationState.value = item
                break
            }
        }
    }
}