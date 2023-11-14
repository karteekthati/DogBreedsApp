package kk.dog.breed.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kk.dog.breed.presentation.screens.BreedDetailScreen
import kk.dog.breed.presentation.screens.BreedsListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.BREEDS_LIST_SCREEN){
        composable(Routes.BREEDS_LIST_SCREEN){
            //BreedsListScreen
            BreedsListScreen(){ breedSelected ->
                navController.navigate("${Routes.BREED_DETAIL_SCREEN}/$breedSelected")
            }
        }
        composable("${Routes.BREED_DETAIL_SCREEN}/{${Routes.SELECTED_BREED}}",
            arguments = listOf(
                navArgument(Routes.SELECTED_BREED){
                    type =  NavType.StringType
                }
            )
        ){navBackStackEntry ->
            val selectedBreed = navBackStackEntry.arguments?.getString(Routes.SELECTED_BREED)
            BreedDetailScreen(selectedBreed?:"")
        }
    }
}