package kk.dog.breed.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import androidx.compose.runtime.*

@Composable
fun CustomListView(list: List<String>, isLoading: Boolean, onClick: (String) -> Unit) {
    if (isLoading) {
        LazyColumn {
            items(20) {
                ShimmerItem()
            }
        }
    } else {
        LazyColumn {
            items(list) { breed ->
                BreedItem(breed, onClick = { onClick(breed) })
            }
        }
    }
}

@Composable
fun BreedItem(breed: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        TextWithSize(text = breed, size = 16.sp)
    }
}


@Composable
fun ShimmerItem() {
    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.View)
    Box(
        modifier = Modifier
            .shimmer(shimmerInstance)
            .fillMaxWidth()
            .height(56.dp)
            .padding(5.dp)
            .background(Color.LightGray, RoundedCornerShape(4.dp))
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(onQueryChanged: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = {
            text = it
            onQueryChanged(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = { Text("Search") },
        shape = RoundedCornerShape(8.dp),  // Rounded corners
        colors = TextFieldDefaults.textFieldColors( // Custom background color
            textColor = Color.Black,           // Custom text color
            cursorColor = Color.Black,         // Custom cursor color
            placeholderColor = Color.Gray      // Custom placeholder color
        )
    )
}


@Composable
fun ImageRoundedCorner(image: Int, text: String, imageSize: Dp = 100.dp){
    val imagePainter = painterResource(id = image)
    Image(
        painter = imagePainter,
        contentDescription = text,
        modifier = Modifier
            .fillMaxWidth()
            .height(imageSize)
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
    )
}

@Composable
fun TextWithSize(text: String, size: TextUnit, textAlign: TextAlign? = TextAlign.Left) {
    Text(
        text = text,
        fontSize = size,
        textAlign = textAlign,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun BoxWithSize(size: Dp){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(size))
}

