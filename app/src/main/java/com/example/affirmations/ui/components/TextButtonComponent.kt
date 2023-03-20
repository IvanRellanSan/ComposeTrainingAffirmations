package com.example.affirmations.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.affirmations.R
import com.example.affirmations.navigation.MainNavigator

@Composable
fun TextButtonComponent(modifier: Modifier = Modifier, id: String = "qwer") {
    val context = LocalContext.current
    val navigator = MainNavigator()
    TextButton(
        onClick = { navigator.goToDetailActivity(id, context) },
        modifier = modifier
    ) {
        Text(
          text = stringResource(R.string.see_more)
        )
      }
}

@Preview
@Composable
fun TextButtonComponentPreview(){
    TextButtonComponent()
}
