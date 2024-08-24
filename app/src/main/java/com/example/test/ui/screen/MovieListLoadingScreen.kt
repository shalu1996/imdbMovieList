package com.example.test.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.test.util.ShimmerAnimation

@Composable
fun MovieListLoadingScreen() {
    val colors = listOf(Color.DarkGray, Color.LightGray)
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ShimmerAnimation(
            shape = RoundedCornerShape(10), modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(10.dp), colors
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        repeat(10) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(2) {
                    Column(verticalArrangement = Arrangement.Center) {
                        ShimmerAnimation(
                            shape = RoundedCornerShape(10), modifier = Modifier
                                .size(200.dp, 200.dp)
                                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 10.dp), colors
                        )
                        ShimmerAnimation(
                            shape = RoundedCornerShape(10), modifier = Modifier
                                .width(200.dp)
                                .height(20.dp)
                                .padding(start = 20.dp, end = 10.dp), colors
                        )
                    }
                }
            }
        }
    }
}