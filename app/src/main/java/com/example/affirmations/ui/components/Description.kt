package com.example.affirmations.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.affirmations.R

@Composable
fun Description(description: String, title: String? = null, modifier: Modifier, id: String) {
    Column(
        modifier = modifier
    ) { 
        Text(
            text = title ?: stringResource(R.string.detail_title),
            style = MaterialTheme.typography.h6,
            fontSize = 30.sp
        )
        Column {
            Text(
                text = description,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            TextButtonComponent(id=id)
        }
    }
}

@Preview
@Composable
fun DescriptionPreview() {
    Description(description = "HOLA camarón con cola", modifier = Modifier, id = "qwer")
}