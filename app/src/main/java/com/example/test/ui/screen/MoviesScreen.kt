package com.example.test.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test.ViewState
import com.example.test.data.model.Movie
import com.example.test.ui.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(viewModel: MoviesViewModel = hiltViewModel()) {
    val data = viewModel.liveData.observeAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.getMovies()
    }

    when (data.value) {
        is ViewState.LOADING -> {
            CircularProgressIndicator()
        }

        is ViewState.SUCCESS -> {
            MovieListScreen(list = data.value?.data ?: emptyList())

        }

        is ViewState.ERROR -> {
            Text(text = "Error : ${data.value?.message}")
        }

        else -> {}
    }

}

@Composable
fun MovieListScreen(list: List<Movie>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(text = "News")
            Spacer(modifier = Modifier.padding(top = 16.dp))
        }
        items(list){
            MovieItem(movies = it)
        }
    }
}

@Composable
fun MovieItem(movies: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        shape = RoundedCornerShape(20),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            Text(text = "List Name - ${movies.id}")
            Text(text = "Display Name - ${movies.type}")
            Text(text = "List Name Encoded - ${movies.login}")
            Text(text = "Oldest Publish Date - ${movies.node_id}")
            Text(text = "Newest Publish Date - ${movies.node_id}")
        }
    }
}