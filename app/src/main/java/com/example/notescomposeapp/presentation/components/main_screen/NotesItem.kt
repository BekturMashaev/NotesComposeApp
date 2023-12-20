package com.example.notescomposeapp.presentation.components.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notescomposeapp.data.models.NotesModel
import com.example.notescomposeapp.presentation.theme.TextDescriptionGray
import com.example.notescomposeapp.presentation.theme.TextTitleGray
import com.example.notescomposeapp.presentation.theme.sp12
import com.example.notescomposeapp.presentation.theme.sp16

@Composable
fun NotesItem(
    modifier: Modifier = Modifier,
    notesModel: NotesModel,
) {
    val randomColor = Color(
        red = (Math.random() * 0.8 + 0.2).toFloat(),
        green = (Math.random() * 0.8 + 0.2).toFloat(),
        blue = (Math.random() * 0.8 + 0.2).toFloat(),
        alpha = 1f
    )
    Card(
        colors = CardDefaults.cardColors(containerColor = randomColor),
        modifier = modifier
            .width(151.dp)
            .padding(5.dp)
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = notesModel.title,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = sp16,
                fontWeight = FontWeight(600),
                letterSpacing = 0.08.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                text = notesModel.description,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = sp12,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center,
                letterSpacing = 0.06.sp,
            )
        }
    }
}