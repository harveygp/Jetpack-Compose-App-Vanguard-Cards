package com.example.submission.ui.presentation.dashboard

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.submission.ui.theme.SubmissionTheme
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.submission.ui.navigation.Screen
import com.example.submission.ui.navigation.SetupNavGraph

@Composable
fun DashboardScreenApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailScreen.route){
                BottomBar(navController = navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->

        SetupNavGraph(navController = navController, innerPadding = innerPadding)
    }
    
}

@Preview
@Composable
fun DashboardScreenAppPreview() {
    SubmissionTheme{
        DashboardScreenApp()
    }
}