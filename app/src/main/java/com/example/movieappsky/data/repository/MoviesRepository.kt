package com.example.movieappsky.data.repository

import com.example.movieappsky.domain.model.Movies
import io.reactivex.Single

interface MoviesRepository {
    fun getMovies(): Single<List<Movies>>
}