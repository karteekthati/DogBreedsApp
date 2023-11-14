package kk.dog.breed.domain.repository

import kk.dog.breed.data.ApiService
import kk.dog.breed.data.MyResult
import javax.inject.Inject

open class MainRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun fetchBreeds(): Map<String, List<String>> {
            val response = apiService.fetchBreeds()
            if (response.status == "success") {
                return response.message
            } else {
                throw RuntimeException("Api call failed")
            }
    }
}