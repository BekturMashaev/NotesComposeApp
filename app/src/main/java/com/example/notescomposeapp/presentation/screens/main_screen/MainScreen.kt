package com.example.notescomposeapp.presentation.screens.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notescomposeapp.data.shared_preferences.NotesDatabase
import com.example.notescomposeapp.presentation.components.main_screen.FloatingActionButton
import com.example.notescomposeapp.presentation.components.main_screen.NotesItem
import com.example.notescomposeapp.presentation.components.main_screen.TopMainScreenBar
import com.example.notescomposeapp.presentation.theme.YellowColorBackground
import com.example.notescomposeapp.presentation.theme.dp5
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen(
            navController = rememberNavController()
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(Color.White)
        systemUiController.setNavigationBarColor(Color.White)
    }
    val sharedPref =
        NotesDatabase(
            LocalContext.current
        )

    Scaffold(
        topBar = {
            TopMainScreenBar(navController = navController)
        },
        content = { innerpading ->
            LazyVerticalStaggeredGrid(
                modifier = modifier
                    .padding(innerpading)
                    .padding(horizontal = dp5),
                columns = StaggeredGridCells.Fixed(2),
                content = {
                    items(sharedPref.getAllNotes()) { item ->
                        NotesItem(notesModel = item)
                    }
                })
        },
        bottomBar = {
            FloatingActionButton(
                navController = navController
            )
        }
    )
}
