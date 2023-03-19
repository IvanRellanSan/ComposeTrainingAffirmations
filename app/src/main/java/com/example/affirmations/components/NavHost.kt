package com.example.affirmations.components

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.affirmations.data.Datasource

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "list"
) {
    val affirmations = Datasource().loadAffirmations()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("list"){
            AffirmationList(
                affirmations,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.background
                    )
            )
        }
    }
}