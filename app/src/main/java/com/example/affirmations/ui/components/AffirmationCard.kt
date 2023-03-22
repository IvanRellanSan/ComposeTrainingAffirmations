package com.example.affirmations.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.Typography
import androidx.compose.runtime.*

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
//    val color by animateColorAsState(
//        targetValue = if (expanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
//    )
    // TODO 1. Your card UI
    Card(
        elevation=10.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ){
        Column(
            modifier = modifier
//                .background(color = MaterialTheme.colors.background)
        ){
            Row{
                Image(painter = painterResource(
                    id = affirmation.imageResourceId),
                    contentDescription = stringResource(id = affirmation.stringResourceId)
                )
                Text(text = stringResource(id = affirmation.stringResourceId),
                    style= Typography.caption,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                        .padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.weight(0.5f))
                ExpandButton(
                    onClick = { expanded = !expanded },
                    expanded = expanded,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }

            if (expanded){
                Description(id = affirmation.id, description = stringResource(id = affirmation.descriptionResourceId), modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 8.dp,
                        bottom = 16.dp,
                        end = 16.dp
                ))
            }
        }

    }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
    // TODO 2. Preview your card
    val affirmations = Datasource().loadAffirmations()
    AffirmationCard(affirmations[0])
}