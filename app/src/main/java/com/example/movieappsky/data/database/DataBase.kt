package com.example.movieappsky.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieData::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun savedDataMoviesDao(): DataMovieDao
}