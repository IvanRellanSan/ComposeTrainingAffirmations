package com.example.affirmations.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colors.secondary else MaterialTheme.colors.surface
    )
    // TODO 1. Your card UI
    Card(
        elevation=10.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ){
        Column(
            modifier = Modifier
                .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
            ))
                .background(color = color)
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
                Button(
                    onClick = { expanded = !expanded },
                    expanded = expanded,
                    modifier = Modifier.align(Alignment.CenterVertically))
            }

            if (expanded){
                Description(description = stringResource(id = affirmation.descriptionResourceId), modifier = Modifier)
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