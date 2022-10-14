package com.example.movieappsky.data.database

import com.example.movieappsky.data.model.MoviesItemsResponse
import io.reactivex.Single

interface LocalDataSource {
    fun addData(movie: MoviesItemsResponse): Single<List<MoviesItemsResponse>>
    fun removeData(movie: MoviesItemsResponse): Single<List<MoviesItemsResponse>>
    fun getSavedData(): Single<List<MoviesItemsResponse>>
}