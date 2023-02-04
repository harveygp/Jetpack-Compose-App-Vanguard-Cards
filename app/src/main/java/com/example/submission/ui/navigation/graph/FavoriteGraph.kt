package com.example.submission.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.submission.ui.navigation.Screen
import com.example.submission.ui.presentation.favorite.FavoriteScreen

fun NavGraphBuilder.favoriteGraph(
    navController: NavHostController
){
    navigation(startDestination = Screen.FavoriteScreen.route,
        route = "favorite_route"){
        composable(
            route = Screen.FavoriteScreen.route
        ){
            FavoriteScreen(
                navigateToDetail = { card ->
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "vanguard",
                        value = card
                    )
                    navController.navigate(route = "detail_route")
                }
            )
        }
    }
}