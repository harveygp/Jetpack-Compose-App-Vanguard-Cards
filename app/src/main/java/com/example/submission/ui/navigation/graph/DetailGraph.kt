package com.example.submission.ui.navigation.graph

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.ui.navigation.Screen
import com.example.submission.ui.presentation.detail.DetailScreen

fun NavGraphBuilder.detailGraph(
    navController: NavHostController
){
    navigation(startDestination = Screen.DetailScreen.route,
        route = "detail_route"){
        composable(
            route = Screen.DetailScreen.route,
        ){
            val vanguard = navController.previousBackStackEntry?.savedStateHandle?.get<Vanguard>("vanguard")
            DetailScreen(card = vanguard)
        }
    }
}