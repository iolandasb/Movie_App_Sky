package com.example.movieappsky.data.repository

import com.example.movieappsky.data.NetworkRetrofit
import com.example.movieappsky.data.Service
import com.example.movieappsky.data.database.LocalDataSourceImpl
import com.example.movieappsky.data.mappers.MoviesMapper
import com.example.movieappsky.domain.model.Movies
import io.reactivex.Single

class MoviesRepositoryImpl: MoviesRepository {
    private val moviesRemoteSource: Service = NetworkRetrofit.getMoviesRemoteSource()
    private val movieLocalDataSource = LocalDataSourceImpl()
    private val movieMapper = MoviesMapper()

    override fun getMovies(): Single<List<Movies>> {
        return moviesRemoteSource
            .getMovies()
            .flatMap { movieResponseList ->
                movieLocalDataSource
                    .getSavedData()
                    .map { savedMovieList ->
                        movieResponseList.movieResults.forEach { movieResponse ->
                            val result = savedMovieList.any { savedMovies ->
                                savedMovies.id == movieResponse.id
                            }
                            movieResponse.savedData = result
                        }
                        movieResponseList.movieResults
                    }
            }
            .map {
                movieMapper.map(it)
            }
    }
}