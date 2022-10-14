package com.example.movieappsky.data.mappers

import com.example.movieappsky.data.model.MoviesItemsResponse
import com.example.movieappsky.domain.model.Movies

class MoviesMapper {
    fun map(movieResponseList: List<MoviesItemsResponse>): List<Movies> {
        val movies = mutableListOf<Movies>()
        movieResponseList.forEach {
            val movie = Movies(
                id = it.id,
                title = it.title,
                year = it.year,
                genre = it.genre,
                poster = it.poster,
                savedData = it.savedData
            )
            movies.add(movie)
        }
        return movies
    }
}