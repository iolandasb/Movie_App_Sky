package com.example.movieappsky.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DataMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg moviesData: MovieData)

    @Query("SELECT * FROM movieData")
    fun getAll(): List<MovieData>

    @Delete
    fun delete(movieData: MovieData)

}