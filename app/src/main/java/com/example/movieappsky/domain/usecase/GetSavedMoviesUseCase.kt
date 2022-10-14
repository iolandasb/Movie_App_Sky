package com.example.movieappsky.domain.usecase

import com.example.movieappsky.data.repository.SavedMoviesRepository
import com.example.movieappsky.data.repository.SavedMoviesRepositoryImpl
import com.example.movieappsky.domain.model.Movies

class GetSavedMoviesUseCase(private val favoriteMoviesRepository: SavedMoviesRepository = SavedMoviesRepositoryImpl()) {

    fun getSavedMovies() = favoriteMoviesRepository.getSavedMovies()
    fun addToSaved(movie: Movies) = favoriteMoviesRepository.addToSaved(movie)
    fun removeFromSaved(movie: Movies) = favoriteMoviesRepository.removeFromSaved(movie)
}