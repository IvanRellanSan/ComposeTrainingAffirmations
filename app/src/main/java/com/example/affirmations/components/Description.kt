package com.example.affirmations.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.R

@Composable
fun Description(description: String, title: String? = null, modifier: Modifier) {
    Column(
        modifier = modifier
    ) { 
        Text(
            text = title ?: stringResource(R.string.detail_title),
            style = MaterialTheme.typography.h6,
            fontSize = 30.sp
        )
        Text(
            text = description,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
fun DescriptionPreview() {
    Description(description = "HOLA camarón con cola", modifier = Modifier)
}