package com.example.movieappsky.data.repository

import com.example.movieappsky.domain.model.Movies
import io.reactivex.Single

interface SavedMoviesRepository {
    fun addToSaved(movie: Movies): Single<List<Movies>>
    fun removeFromSaved(movie: Movies): Single<List<Movies>>
    fun getSavedMovies(): Single<List<Movies>>
}