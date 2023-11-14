package kk.dog.breed.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kk.dog.breed.R
import kk.dog.breed.presentation.components.ImageRoundedCorner
import kk.dog.breed.presentation.components.BoxWithSize
import kk.dog.breed.presentation.components.TextWithSize

@Composable
fun BreedDetailScreen(selectedBreed: String) {
    ElevatedCard(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp)) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BoxWithSize(50.dp)
            ImageRoundedCorner(R.drawable.dog_img, "breed image")
            BoxWithSize(100.dp)
            TextWithSize("Details with $selectedBreed", 14.sp, TextAlign.Center)
        }

    }
}