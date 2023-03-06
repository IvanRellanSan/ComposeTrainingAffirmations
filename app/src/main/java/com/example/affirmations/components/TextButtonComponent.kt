package com.example.affirmations.components

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.affirmations.R

@Composable
fun TextButtonComponent(modifier: Modifier = Modifier) {
//    val count = rememberSaveable { mutableStateOf(0) }
    TextButton(
        onClick = { /*count.value += 1*/ },
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