package com.example.submission.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.submission.ui.navigation.graph.aboutGraph
import com.example.submission.ui.navigation.graph.detailGraph
import com.example.submission.ui.navigation.graph.favoriteGraph
import com.example.submission.ui.navigation.graph.homeGraph

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    innerPadding : PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "home_route",
        modifier = Modifier.padding(innerPadding)
    ){
        homeGraph(navController = navController)
        favoriteGraph(navController = navController)
        aboutGraph(navController = navController)
        detailGraph(navController = navController)
    }
}