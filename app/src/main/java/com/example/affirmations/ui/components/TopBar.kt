package com.example.affirmations.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBar() {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Abrir menú desplegable")
            }
        },
        title = { Text(text = "Affirmations App") },
        actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorito")
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Más")
            }
        }
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}