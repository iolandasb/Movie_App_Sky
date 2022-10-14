package com.example.movieappsky.data.model

import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    @SerializedName("data")
    val movieResults: List<MoviesItemsResponse>
)
