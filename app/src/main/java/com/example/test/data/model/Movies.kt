package com.example.test.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
    @PrimaryKey
    val id: Int,
    val title: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("media_type")
    val mediaType: String,
    val adult: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    val popularity: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val video: String,
    @SerializedName("vote_average")
    val voteAverage: String,
    @SerializedName("vote_count")
    val voteCount: String
)