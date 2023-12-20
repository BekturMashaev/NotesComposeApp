package com.example.notescomposeapp.presentation.screens.details_screen

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notescomposeapp.R
import com.example.notescomposeapp.presentation.components.details_screen.TopDetailsBar
import com.example.notescomposeapp.presentation.theme.TextDescriptionGray
import com.example.notescomposeapp.presentation.theme.TextTitleGray
import com.example.notescomposeapp.presentation.theme.YellowColorBackground
import com.example.notescomposeapp.presentation.theme.sp20
import com.example.notescomposeapp.presentation.theme.sp30
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun DetailsScreensPreview() {
    MaterialTheme {
        DetailsScreen(navController = rememberNavController())
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(YellowColorBackground)
        systemUiController.setNavigationBarColor(YellowColorBackground)
    }
    var titleTextValue by remember { mutableStateOf("") }
    var descriptionTextValue by remember { mutableStateOf("") }
    Scaffold(
        containerColor = YellowColorBackground,
        topBar = {
            TopDetailsBar(
                navController = navController,
                title = titleTextValue,
                description = descriptionTextValue,
                context = LocalContext.current
            )
        },
        content = { innerpadding ->
            Column(
                modifier = modifier
                    .padding(innerpadding)
                    .padding(horizontal = 30.dp)
            ) {
                TextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(),
                    value = titleTextValue,
                    onValueChange = {
                        titleTextValue = it
                    },
                    modifier = modifier
                        .fillMaxWidth(),
                    maxLines = 2,
                    label = {
                        Text(
                            modifier = modifier.fillMaxWidth(),
                            text = stringResource(R.string.type_something_txt),
                            color = TextTitleGray,
                            fontSize = sp30,
                            fontWeight = FontWeight(600),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.15.sp,
                        )
                    },
                )
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                    ),
                    value = descriptionTextValue,
                    onValueChange = {
                        descriptionTextValue = it
                    },
                    modifier = modifier
                        .fillMaxSize(),
                    maxLines = 2,
                    label = {
                        Text(
                            modifier = modifier.fillMaxWidth(),
                            text = stringResource(R.string.type_something_txt),
                            color = TextDescriptionGray,
                            fontSize = sp20,
                            fontWeight = FontWeight(500),
                        )
                    },
                )
            }
        }
    )
}