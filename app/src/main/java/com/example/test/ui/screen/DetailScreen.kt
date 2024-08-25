package com.example.test.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.test.IMAGE_BASE_ORIGINAL_URL
import com.example.test.ui.viewmodel.MoviesViewModel

@Composable
fun DetailScreen(viewModel: MoviesViewModel, navController: NavController) {
    val movieId = navController.currentBackStackEntry?.arguments?.getString("movieId")
    val movie = movieId?.let { viewModel.getMovieById(movieId.toInt()) }
    val painter = "$IMAGE_BASE_ORIGINAL_URL${movie?.posterPath}"
    Column {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            tint = Color.Gray,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .clickable {
                    navController.navigateUp()
                }
        )
        AsyncImage(
            model = painter,
            contentDescription = "Movie ICON",
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(20.dp)
                .clip(RoundedCornerShape(5)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            text = movie?.title.toString(),
            modifier = Modifier.padding(horizontal = 20.dp),
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            text = movie?.overview.toString(),
            modifier = Modifier.padding(horizontal = 20.dp),
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}