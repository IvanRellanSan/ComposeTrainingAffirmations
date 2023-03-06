package com.example.affirmations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.R
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.Typography

@Composable
fun DetailComponent(modifier: Modifier = Modifier, affirmation: Affirmation) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = affirmation.imageResourceId),
            contentDescription = stringResource(id = affirmation.stringResourceId),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(text = stringResource(id = affirmation.stringResourceId),
            style= Typography.h4,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
//                .weight(1f)
        )
        Text(text = stringResource(id = affirmation.descriptionResourceId),
            style= Typography.body2,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
//                .weight(1f)
        )
    }
}

@Preview
@Composable
fun DetailComponentPreview() {
    val affirmations = Datasource().loadAffirmations()
    DetailComponent(affirmation = affirmations[0])
}