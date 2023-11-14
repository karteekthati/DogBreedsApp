package kk.dog.breed.data

import kk.dog.breed.domain.model.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("breeds/list/all")
    suspend fun fetchBreeds(): ApiResponse
}