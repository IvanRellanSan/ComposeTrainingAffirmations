package com.example.affirmations.components

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextButtonComponent(modifier: Modifier = Modifier) {
    val count = rememberSaveable { mutableStateOf(0) }
    TextButton(
        onClick = { count.value += 1 },
        modifier = modifier
    ) {
        Text(
          text = "Me han pulsado ${count.value} vez/veces"
        )
      }
}

@Preview
@Composable
fun TextButtonComponentPreview(){

}