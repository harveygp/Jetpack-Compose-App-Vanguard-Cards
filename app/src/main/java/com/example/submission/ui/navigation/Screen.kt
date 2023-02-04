package com.example.submission.ui.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object AboutScreen : Screen("about")
    object FavoriteScreen : Screen("favorite")
    object DetailScreen : Screen("detail")
}