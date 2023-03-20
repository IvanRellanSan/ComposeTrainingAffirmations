package com.example.affirmations.components

import android.content.Context
import android.content.Intent
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.affirmations.DetailActivity
import com.example.affirmations.R
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.navigation.MainNavigator

@Composable
fun TextButtonComponent(modifier: Modifier = Modifier, id: String = "qwer") {
    val context = LocalContext.current
    val navigator: MainNavigator = MainNavigator()
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
