package com.example.submission.ui.presentation.dashboard

import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.submission.R
import com.example.submission.ui.navigation.NavigationItem
import com.example.submission.ui.navigation.Screen
import com.example.submission.ui.theme.SubmissionTheme

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier : Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.HomeScreen
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_favorite),
                icon = Icons.Default.Favorite,
                screen = Screen.FavoriteScreen
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_about),
                icon = Icons.Default.Person,
                screen = Screen.AboutScreen
            )
        )

        BottomNavigation {
            navigationItems.map { item ->
                BottomNavigationItem(
                    icon = {
                           Icon(
                               imageVector = item.icon,
                               contentDescription = item.title
                           )
                    },
                    label = { Text(text = item.title) },
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        Log.d("Pencet","$currentRoute dimana routenya ${item.screen.route}")
                              navController.navigate(item.screen.route){
                                  popUpTo(navController.graph.findStartDestination().id){
                                      saveState = true
                                  }
                                  restoreState = true
                                  launchSingleTop = true
                              }
                        Log.d("Pencet","$currentRoute dimana routenya ${item.screen.route}")
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    SubmissionTheme{
        BottomBar(navController= rememberNavController())
    }
}