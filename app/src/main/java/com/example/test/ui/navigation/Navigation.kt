package com.example.test.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.test.NAV_OPTION
import com.example.test.ui.screen.DetailsScreen
import com.example.test.ui.screen.MoviesScreen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NAV_OPTION.USER_SCREEN.name) {
        composable(route = NAV_OPTION.USER_SCREEN.name) {
            MoviesScreen()
        }
        composable(route = NAV_OPTION.NEWS_SCREEN.name) {
            DetailsScreen()
        }
    }
}