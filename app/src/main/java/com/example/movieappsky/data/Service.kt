package com.example.movieappsky.data

import com.example.movieappsky.data.model.MoviesListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface Service {
    @GET("/api/movies")
    fun getMovies(): Single<MoviesListResponse>
}