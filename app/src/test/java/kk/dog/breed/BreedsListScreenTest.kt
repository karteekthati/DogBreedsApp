package kk.dog.breed

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import kk.dog.breed.domain.repository.MainRepository
import kk.dog.breed.presentation.screens.BreedsListScreen
import kk.dog.breed.presentation.viewmodels.DogBreedViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as whenever
import org.junit.Test
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import kk.dog.breed.data.ApiService
import kk.dog.breed.domain.model.ApiResponse


//@OptIn(ExperimentalComposeUiApi::class)
//class BreedsListScreenTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    private val mockApiService = mock(ApiService::class.java)
//    private lateinit var viewModel: DogBreedViewModel
//    private lateinit var mockRepository: MainRepository
//
//    @Before
//    fun setup() {
//        runBlocking {
//            val breedData = mapOf("Labrador" to listOf("Breed1", "Breed2"))
//            val apiResponse = ApiResponse(breedData, "success")
//            whenever(mockApiService.fetchBreeds()).thenReturn(apiResponse)
//        }
//
//        mockRepository = MainRepository(mockApiService)
//        viewModel = DogBreedViewModel(mockRepository)
//    }
//
//    @Test
//    fun breedsListScreen_SuccessState() {
//        runBlocking {
//            // Arrange
//            viewModel.fetchBreeds()
//
//            composeTestRule.setContent {
//                BreedsListScreen { /* navigation logic here */ }
//            }
//
//            // Assert
//            composeTestRule.onNodeWithText("Labrador").assertIsDisplayed()
//        }
//    }
//}

