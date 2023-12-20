package com.example.notescomposeapp.presentation.components.main_screen

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notescomposeapp.R
import com.example.notescomposeapp.presentation.theme.sp16

@Preview
@Composable
fun TopBatPreview() {
    MaterialTheme {
        TopMainScreenBar(
            navController = rememberNavController(),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopMainScreenBar(
    navController: NavController,
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(painter = painterResource(id = R.drawable.menu), contentDescription = null)
            }
        },
        title = {
            Text(
                text = stringResource(R.string.recent_notes_title_top_bar),
                color = MaterialTheme.colorScheme.primary,
                fontSize = sp16,
                fontWeight = FontWeight(600),
                textAlign = TextAlign.Center,
            )
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(painter = painterResource(id = R.drawable.search), contentDescription = null)
            }
        }
    )
}