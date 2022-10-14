package com.example.movieappsky.data.database

import com.example.movieappsky.data.mappers.MovieDataMapper
import com.example.movieappsky.data.mappers.MovieResponseMapper
import com.example.movieappsky.data.model.MoviesItemsResponse
import io.reactivex.Single
import java.lang.IllegalStateException

class LocalDataSourceImpl: LocalDataSource {
    private val dao = DataBaseProvider.getMoviesDao()
    private val movieDataMapper = MovieDataMapper()
    private val movieResponseMapper = MovieResponseMapper()

    override fun addData(movie: MoviesItemsResponse): Single<List<MoviesItemsResponse>> {
        return Single.create { emitter ->
            dao?.let{
                val mappedMovie = movieDataMapper.map(movie)
                dao.insert(mappedMovie)
                val savedDataMovies = dao.getAll()
                emitter.onSuccess(savedDataMovies.map())
            } ?: emitter.onError(IllegalStateException())
        }
    }

    override fun removeData(movie: MoviesItemsResponse): Single<List<MoviesItemsResponse>> {
        return Single.create { emitter ->
            dao?.let{
                val mappedMovie = movieDataMapper.map(movie)
                dao.delete(mappedMovie)
                val savedDataMovies = dao.getAll()
                emitter.onSuccess(savedDataMovies.map())
            } ?: emitter.onError(IllegalStateException())
        }
    }

    override fun getSavedData(): Single<List<MoviesItemsResponse>> {
        return Single.create { emitter ->
            dao?.let{
                val savedDataMovies = dao.getAll()
                emitter.onSuccess(savedDataMovies.map())
            } ?: emitter.onError(IllegalStateException())
        }
    }

    private fun List<MovieData>.map(): List<MoviesItemsResponse> {
        return this.map { movie ->
            movieResponseMapper.map(movie)
        }
    }
}