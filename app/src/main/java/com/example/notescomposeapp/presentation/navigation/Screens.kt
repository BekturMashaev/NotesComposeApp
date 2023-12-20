package com.example.notescomposeapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import com.example.notescomposeapp.R

@SuppressLint("SupportAnnotationUsage")
sealed class Screens(@StringRes val route:Int) {
    object MainScreen:Screens(R.string.main_screen_route)
    object DetailsScreen:Screens(R.string.details_screen_route)
}