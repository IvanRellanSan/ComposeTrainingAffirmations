package com.example.affirmations.ui.viewmodel

import com.example.affirmations.data.Datasource
import org.junit.Assert.*
import org.junit.Test

class DetailViewModelTest {
    private val viewModel = DetailViewModel()
    private val list = Datasource().loadAffirmations()

    @Test
    fun detailViewModel_DataLoadedCorrectly() {
        assertEquals(null, viewModel.affirmationState.value)

        viewModel.loadItem("qwer")
        assertNotEquals(null, viewModel.affirmationState.value)
        assertEquals(list.first(), viewModel.affirmationState.value)
    }

    @Test
    fun detailViewModel_DataLoadedEmpty() {
        assertEquals(null, viewModel.affirmationState.value)

        viewModel.loadItem("1234")
        assertEquals(null, viewModel.affirmationState.value)

//        viewModel.loadData()
//        assertNotEquals(emptyList<Affirmation>(), viewModel.listState.value)
//        assertEquals(Datasource().loadAffirmations(), viewModel.listState.value)
    }
}