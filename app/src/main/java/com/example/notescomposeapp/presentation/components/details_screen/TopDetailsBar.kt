package com.example.notescomposeapp.presentation.components.details_screen


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notescomposeapp.R
import com.example.notescomposeapp.data.models.NotesModel
import com.example.notescomposeapp.data.shared_preferences.NotesDatabase
import com.example.notescomposeapp.presentation.theme.YellowColorBackground
import com.example.notescomposeapp.presentation.theme.sp16
import com.google.accompanist.systemuicontroller.rememberSystemUiController

//@Preview
//@Composable
//fun TopBatPreview() {
//    MaterialTheme {
//        TopDetailsBar(
//            navController = rememberNavController(),
//            title = "f",
//            description = "fr",
//            context
//        )
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopDetailsBar(
    navController: NavController,
    title: String,
    context: Context,
    description: String
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(YellowColorBackground)
        systemUiController.setNavigationBarColor(YellowColorBackground)
    }
    val sharedPref =
        NotesDatabase(LocalContext.current)
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(YellowColorBackground),
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = null,
                )
            }
        },
        title = {
            Text(
                text = stringResource(R.string.edit_note_title_top_bar),
                color = MaterialTheme.colorScheme.primary,
                fontSize = sp16,
                fontWeight = FontWeight(600),
                textAlign = TextAlign.Center,
            )
        },
        actions = {
            IconButton(onClick = {
                if (title.isNotEmpty()){
                    sharedPref.saveNotes(
                        NotesModel(
                            title = title,
                            description = description
                        )
                    )
                    navController.popBackStack()
                }
                else showToastManager(massage = "Fields are empty!", context = context)
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = null,
                )
            }
        }
    )
}
fun showToastManager(massage: String, context: Context) {
    Toast.makeText(
        context,
        massage,
        Toast.LENGTH_LONG,
    ).show()
}