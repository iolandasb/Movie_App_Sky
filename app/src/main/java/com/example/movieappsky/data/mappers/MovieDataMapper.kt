package com.example.movieappsky.data.mappers

import com.example.movieappsky.data.database.MovieData
import com.example.movieappsky.data.model.MoviesItemsResponse

class MovieDataMapper {
    fun map(movie: MoviesItemsResponse): MovieData {
        return MovieData(
            id = movie.id,
            title = movie.title,
            year = movie.year,
            genre = movie.genre,
            poster = movie.poster
        )
    }
}