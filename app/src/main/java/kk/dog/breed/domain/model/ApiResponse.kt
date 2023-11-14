package kk.dog.breed.domain.model

data class ApiResponse(
    val message: Map<String, List<String>>,
    val status: String
)
