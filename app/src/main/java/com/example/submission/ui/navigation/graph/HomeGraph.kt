package com.example.submission.ui.navigation.graph

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.submission.ui.navigation.Screen
import com.example.submission.ui.presentation.home.HomeScreen

fun NavGraphBuilder.homeGraph(
    navController: NavHostController
){
    navigation(startDestination = Screen.HomeScreen.route,
        route = "home_route"){
        composable(
            route = Screen.HomeScreen.route
        ){
            HomeScreen(
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