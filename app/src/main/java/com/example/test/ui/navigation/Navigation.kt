package com.example.test.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.test.NAV_OPTION
import com.example.test.ui.screen.DetailScreen
import com.example.test.ui.screen.MoviesScreen
import com.example.test.ui.viewmodel.MoviesViewModel

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    val viewModel: MoviesViewModel = hiltViewModel()
    NavHost(
        navController = navHostController,
        startDestination = NAV_OPTION.MOVIE_LIST_SCREEN.name
    ) {
        composable(route = NAV_OPTION.MOVIE_LIST_SCREEN.name) {
            MoviesScreen(navController = navHostController, viewModel = viewModel)
        }
        composable(route = NAV_OPTION.DETAIL_SCREEN.name+"/{movieId}") {
            DetailScreen(navController = navHostController, viewModel = viewModel)
        }
    }
}