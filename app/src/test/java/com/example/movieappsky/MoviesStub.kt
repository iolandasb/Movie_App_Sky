package com.example.movieappsky

import com.example.movieappsky.domain.model.Movies

object MoviesStub {

    val listMoviesMock = listOf(
        Movies(
            id = 11241,
            title = "Jumanji: welcome to the jungle",
            year = "2017",
            genre = "Action",
            poster = "https://image.tmdb.org/t/p/w370_and_h556_bestv2/bXrZ5iHBEjH7WMidbUDQ0U2xbmr.jpg",
            savedData = false
        )
    )
}