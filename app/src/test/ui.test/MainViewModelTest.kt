package com.example.affirmations.ui.viewmodel

import com.example.affirmations.model.Affirmation
import org.junit.Assert.*
import org.junit.Test

class MainViewModelTest {
    private val viewModel = MainViewModel()

    @Test
    fun mainViewModel_DataLoadedCorrectly() {
        assertEquals(emptyList<Affirmation>(), viewModel.listState.value)
    }
}