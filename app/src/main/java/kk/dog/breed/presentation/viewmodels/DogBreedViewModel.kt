package kk.dog.breed.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kk.dog.breed.data.MyResult
import kk.dog.breed.data.MyResult.*
import kk.dog.breed.domain.repository.MainRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogBreedViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    private val _breeds = mutableStateOf<MyResult<Map<String, List<String>>>>(Loading)
    val breeds: State<MyResult<Map<String, List<String>>>> = _breeds

    init {
        fetchBreeds()
    }

    fun fetchBreeds() {
        viewModelScope.launch {
            _breeds.value =  Loading
            _breeds.value = try {
                Success(repository.fetchBreeds())
            } catch (e: Exception) {
                Failure(e)
            }
        }
    }
}