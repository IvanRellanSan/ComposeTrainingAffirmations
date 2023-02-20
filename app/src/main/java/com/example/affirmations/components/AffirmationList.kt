package com.example.affirmations.components
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = affirmationList,
            itemContent = {
                AffirmationCard(affirmation = it)
            })
    }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
    // TODO 2. Preview your card
    val affirmations = Datasource().loadAffirmations()
    AffirmationList(affirmations)
}
