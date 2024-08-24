package com.example.test.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//"backdrop_path": "/sRLC052ieEzkQs9dEtPMfFxYkej.jpg",
//            "id": 848326,
//            "title": "Rebel Moon - Part One: A Child of Fire",
//            "original_title": "Rebel Moon - Part One: A Child of Fire",
//            "overview": "When the ruthless forces of the Motherworld threaten a quiet farming village on a distant moon, a mysterious outsider becomes its best hope for survival.",
//            "poster_path": "/ui4DrH1cKk2vkHshcUcGt2lKxCm.jpg",
//            "media_type": "movie",
//            "adult": false,
//            "original_language": "en",
//            "genre_ids": [
//                878,
//                18,
//                28
//            ],
//            "popularity": 94.253,
//            "release_date": "2023-12-15",
//            "video": false,
//            "vote_average": 6.3,
//            "vote_count": 2016

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
    val voteCount: String,
//    @SerializedName("genre_ids")
//    val genreIds: List<Int>,
)