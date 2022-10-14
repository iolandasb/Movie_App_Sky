package com.example.movieappsky.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieData(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String? = null,
    @ColumnInfo(name = "year")
    val year: String? = null,
    @ColumnInfo(name = "genre")
    val genre: String? = null,
    @ColumnInfo(name = "poster")
    val poster: String? = null,
    @ColumnInfo(name = "isFavorite")
    val savedData: Boolean = false
)
