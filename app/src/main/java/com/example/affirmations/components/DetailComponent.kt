package com.example.affirmations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.navigation.DetailNavigator
import com.example.affirmations.ui.theme.Typography


@Composable
fun DetailComponent(modifier: Modifier = Modifier, affirmation: Affirmation) {
    val context = LocalContext.current
    val navigator: DetailNavigator = DetailNavigator()
    Column(
        modifier = modifier
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = affirmation.imageResourceId),
            contentDescription = stringResource(id = affirmation.stringResourceId),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 22.dp)
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
                .padding(start = 32.dp, end = 32.dp, bottom = 10.dp)
//                .weight(1f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp, start = 32.dp),
            horizontalArrangement = Arrangement.End
        ){
            IconButton(onClick = { navigator.sendEmail(context, affirmation.email, "Hola camarón con cola") }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email button"
                )
            }

            IconButton(onClick = { navigator.dial(context, affirmation.phone) }) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Email button"
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailComponentPreview() {
    val affirmations = Datasource().loadAffirmations()
    DetailComponent(affirmation = affirmations[0])
}