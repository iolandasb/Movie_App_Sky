package com.example.movieappsky.domain.usecase

import com.example.movieappsky.data.repository.MoviesRepository
import com.example.movieappsky.data.repository.MoviesRepositoryImpl

class GetMoviesUseCase(private val moviesRepository: MoviesRepository = MoviesRepositoryImpl()) {
    fun execute() = moviesRepository.getMovies()
}