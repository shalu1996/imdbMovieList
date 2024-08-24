package com.example.test.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.test.IMAGE_BASE_URL
import com.example.test.NAV_OPTION
import com.example.test.ViewState
import com.example.test.data.model.Movie
import com.example.test.ui.theme.lightGrey
import com.example.test.ui.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(viewModel: MoviesViewModel = hiltViewModel(), navController: NavController) {
    val data = viewModel.countriesList.collectAsState()
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    when (data.value) {
        is ViewState.LOADING -> {
            MovieListLoadingScreen()
        }

        is ViewState.SUCCESS -> {
            MovieListScreen(
                list = data.value.data ?: emptyList(),
                viewModel = viewModel,
                searchText,
                isSearching
            ) {
                navController.navigate(NAV_OPTION.DETAIL_SCREEN.name + "/$it")
            }
        }

        is ViewState.ERROR -> {
            ErrorScreen(errorMessage = data.value.message.toString())
        }

    }

}

@Composable
fun MovieListScreen(
    list: List<Movie>, viewModel: MoviesViewModel, searchText: String, isSearching: Boolean,
    onClick: (Int) -> Unit
) {
    Column {
        CustomSearchBar(query = searchText,//text showed on SearchBar
            onQueryChange = viewModel::onSearchTextChange, //update the value of searchText
            onSearch = {}, //the callback to be invoked when the input service triggers the ImeAction.Search action
            active = isSearching, //whether the user is searching or not
            onActiveChange = {}, //the callback to be invoked when this search bar's active state is changed
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = lightGrey,
                    contentDescription = null
                )
            }, trailingIcon = {
                if (searchText.isNotEmpty()) {
                    IconButton(onClick = { viewModel.onSearchTextChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            tint = lightGrey,
                            contentDescription = "Clear search"
                        )
                    }
                }
            },
            placeHolder = { Text(text = "Search Movies", color = lightGrey) }) {}
        if (list.isEmpty()) {
            MovieListEmptyState()
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize().padding(end = 20.dp, bottom = 20.dp)
            ) {
                items(list) {
                    MovieItem(movies = it, onClick = onClick)
                }
            }
        }
    }
}

@Composable
fun MovieItem(movies: Movie, onClick: (Int) -> Unit) {
    val painter = "$IMAGE_BASE_URL${movies.posterPath}"

    Column(modifier = Modifier
        .padding(top = 20.dp, start = 20.dp)
        .clickable {
            onClick.invoke(movies.id)
        }) {
        AsyncImage(
            model = painter,
            contentDescription = "Movie Icon",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .clip(RoundedCornerShape(5)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = movies.title, fontSize = 16.sp, color = Color.Black)
    }
}


