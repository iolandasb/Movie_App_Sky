package com.example.movieappsky.domain.model

data class Movies(
    val id: Int,
    val title: String? = null,
    val year: String? = null,
    val genre: String? = null,
    val poster: String? = null,
    var savedData: Boolean = false
)
