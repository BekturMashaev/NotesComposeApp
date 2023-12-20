package com.example.notescomposeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notescomposeapp.presentation.screens.details_screen.DetailsScreen
import com.example.notescomposeapp.presentation.screens.main_screen.MainScreen

@Composable
fun NotesNavigation() {
    val navController = rememberNavController()
    val mainScreenRoute = Screens.MainScreen.route.toString()
    val detailsScreenRoute = Screens.DetailsScreen.route.toString()
    NavHost(
        navController = navController,
        startDestination = mainScreenRoute,
    ){
        composable(mainScreenRoute) {
            MainScreen(navController=navController)
        }
        composable(detailsScreenRoute) {
            DetailsScreen(navController=navController)
        }
    }
}