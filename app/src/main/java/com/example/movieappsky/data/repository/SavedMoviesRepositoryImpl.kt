package com.example.movieappsky.data.repository

import com.example.movieappsky.data.database.LocalDataSourceImpl
import com.example.movieappsky.data.mappers.MovieResponseMapper
import com.example.movieappsky.data.mappers.MoviesMapper
import com.example.movieappsky.domain.model.Movies
import io.reactivex.Single

class SavedMoviesRepositoryImpl: SavedMoviesRepository {
    private val movieLocalDataSource = LocalDataSourceImpl()
    private val movieMapper = MoviesMapper()
    private val movieResponseMapper = MovieResponseMapper()

    override fun addToSaved(movie: Movies): Single<List<Movies>> {
        val movieMapped = movieResponseMapper.map(movie)
        return movieLocalDataSource
            .addData(movieMapped)
            .map{
                movieMapper.map(it)
            }
    }

    override fun removeFromSaved(movie: Movies): Single<List<Movies>> {
        val movieMapped = movieResponseMapper.map(movie)
        return movieLocalDataSource
            .removeData(movieMapped)
            .map {
                movieMapper.map(it)
            }
    }

    override fun getSavedMovies(): Single<List<Movies>> {
        return movieLocalDataSource
            .getSavedData()
            .map {
                movieMapper.map(it)
            }
    }
}