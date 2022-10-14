package com.example.movieappsky.data.mappers

import com.example.movieappsky.data.database.MovieData
import com.example.movieappsky.data.model.MoviesItemsResponse
import com.example.movieappsky.domain.model.Movies

class MovieResponseMapper {
    fun map(movie: Movies): MoviesItemsResponse {
        return MoviesItemsResponse(
            id = movie.id,
            title = movie.title,
            year = movie.year,
            genre = movie.genre,
            poster = movie.poster,
            savedData = movie.savedData
        )
    }

    fun map(movie: MovieData): MoviesItemsResponse {
        return MoviesItemsResponse(
            id = movie.id,
            title = movie.title,
            year = movie.year,
            genre = movie.genre,
            poster = movie.poster,
            savedData = movie.savedData
        )
    }

    private fun String.asIntList(): List<Int> {
        return this.split(",").map { it.trim().toInt() }
    }
}