package kk.dog.breed.core

sealed class Routes {
    companion object {
        const val BREEDS_LIST_SCREEN = "BREEDS_LIST_SCREEN"
        const val BREED_DETAIL_SCREEN = "BREED_DETAIL_SCREEN"
        const val SELECTED_BREED = "SELECTED_BREED"
    }
}