package com.example.movieappsky.data.model

import com.google.gson.annotations.SerializedName

data class MoviesItemsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("year")
    val year: String? = null,
    @SerializedName("genre")
    val genre: String? = null,
    @SerializedName("poster")
    val poster: String? = null,
    var savedData: Boolean = false
)
