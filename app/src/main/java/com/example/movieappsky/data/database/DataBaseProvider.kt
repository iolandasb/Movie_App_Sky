package com.example.movieappsky.data.database

import android.content.Context
import androidx.room.Room

private const val DATABASE_NAME: String = "MOVIE_DATABASE"

object DataBaseProvider {
    private var dataBase: DataBase? = null

    fun initDatabase(context: Context){
        dataBase = Room.databaseBuilder(
            context, DataBase::class.java, DATABASE_NAME
        ).build()
    }

    fun getMoviesDao(): DataMovieDao? {
        dataBase?.let{
            return it.savedDataMoviesDao()
        }
        return null
    }
}