package kk.dog.breed.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import kk.dog.breed.data.MyResult
import kk.dog.breed.presentation.components.CustomListView
import kk.dog.breed.presentation.components.SearchBar
import kk.dog.breed.presentation.viewmodels.DogBreedViewModel


@Composable
fun BreedsListScreen(navigateToDetailScreen: (String) -> Unit) {
    val viewModel: DogBreedViewModel = hiltViewModel()
    var searchQuery by remember { mutableStateOf("") }

    when (val breedResult = viewModel.breeds.value) {
        is MyResult.Success -> {
            Column {
                SearchBar(onQueryChanged = { query ->
                    searchQuery = query
                })
                CustomListView(
                    list = breedResult.data.keys.toList()
                        .filter { it.contains(searchQuery, ignoreCase = true) },
                    isLoading = false
                ) { selectedBreed ->
                    navigateToDetailScreen(selectedBreed)
                }
            }
        }

        is MyResult.Failure -> {
            Text("Failed to load breeds: ${breedResult.exception.message}")
        }

        is MyResult.Loading -> {
            CustomListView(emptyList(), true, onClick = {})
        }
    }
}


