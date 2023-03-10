package com.example.affirmations.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.R
import com.example.affirmations.components.Description
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation


@Composable
fun Detail(affirmation: Affirmation, modifier: Modifier) {
    Column() {
        Image(
            painter = painterResource(
            id = affirmation.imageResourceId
            ),
            contentDescription = stringResource(affirmation.stringResourceId),
            modifier = Modifier
                .size(140.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp)
        )
        Description(
            title = stringResource(id = affirmation.stringResourceId),
            description = stringResource(id = affirmation.descriptionResourceId),
            modifier = Modifier)
    }
}

@Preview
@Composable
fun DetailPreview(){
    val affirmations = Datasource().loadAffirmations()
    Detail(affirmations[0], Modifier)
}