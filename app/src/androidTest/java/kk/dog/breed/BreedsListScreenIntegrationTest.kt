package kk.dog.breed

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kk.dog.breed.data.ApiService
import kk.dog.breed.domain.model.ApiResponse
import kk.dog.breed.domain.repository.MainRepository
import kk.dog.breed.presentation.screens.BreedsListScreen
import kk.dog.breed.presentation.viewmodels.DogBreedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import retrofit2.Response
import org.mockito.Mockito.`when` as whenever

@HiltAndroidTest
class BreedsListScreenIntegrationTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val mockApiService = mock(ApiService::class.java)
    private lateinit var viewModel: DogBreedViewModel
    private lateinit var mockRepository: MainRepository

    @Before
    fun setUp() {
        hiltRule.inject()

        // Use runBlocking for setting up the mock for the suspend function
        runBlocking {
            val breedData = mapOf("Labrador" to listOf("Breed1", "Breed2"))
            val apiResponse = ApiResponse(breedData, "success")
            whenever(mockApiService.fetchBreeds()).thenReturn(apiResponse)
        }

        mockRepository = MainRepository(mockApiService)

        viewModel = DogBreedViewModel(mockRepository)
    }


    @Test
    fun breedsListScreen_IntegrationWithViewModel() = runTest {
        viewModel.fetchBreeds()
        composeTestRule.waitForIdle()
        // Assert UI state based on ViewModel's state
        composeTestRule.onNodeWithText("Labrador").assertIsDisplayed()
    }
}


