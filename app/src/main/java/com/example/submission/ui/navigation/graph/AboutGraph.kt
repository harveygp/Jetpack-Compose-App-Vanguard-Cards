package com.example.submission.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.submission.ui.navigation.Screen
import com.example.submission.ui.presentation.about.AboutScreen


fun NavGraphBuilder.aboutGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.AboutScreen.route,
        route = "about_route"){
        composable(
            route = Screen.AboutScreen.route
        ){
            AboutScreen()
        }
    }
}