package com.example.movieappsky.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappsky.domain.model.Movies
import com.example.movieappsky.domain.usecase.GetMoviesUseCase
import com.example.movieappsky.domain.usecase.GetSavedMoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MoviesViewModel: ViewModel() {

    private val getMoviesUseCase = GetMoviesUseCase()
    private val getSavedMoviesUseCase = GetSavedMoviesUseCase()

    private val _moviesLiveData = MutableLiveData<List<Movies>>(mutableListOf())
    val movieListLiveData : LiveData<List<Movies>> = _moviesLiveData

    private val _savedMoviesLiveData = MutableLiveData<List<Movies>>(mutableListOf())
    val savedMoviesLiveData : LiveData<List<Movies>> = _savedMoviesLiveData

    private val disposable = CompositeDisposable()

    fun getMovies(){
        getMoviesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result ->
                    _moviesLiveData.value = result
                },
                {
                    Log.e("ErroReq", "erro: " + it.cause)
                }
            ).handleDisposable()
    }

    fun getFavoriteMovies(){
        getSavedMoviesUseCase.getSavedMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _savedMoviesLiveData.value = it
                },
                {
                    print(it.message)
                }
            ).handleDisposable()
    }

    fun addToFavorites(movie: Movies){
        getSavedMoviesUseCase.addToSaved(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _savedMoviesLiveData.value = it
                },
                {
                    print(it.message)
                }
            ).handleDisposable()
    }

    fun removeFromFavorites(movieToRemove: Movies){
        getSavedMoviesUseCase.removeFromSaved(movieToRemove)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _savedMoviesLiveData.value = it
                    val result = _moviesLiveData.value?.find { movie ->
                        movie.id == movieToRemove.id
                    }
                    result?.let { movie ->
                        movie.savedData = false
                    }
                },
                {
                    print(it.message)
                }
            ).handleDisposable()
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    private fun Disposable.handleDisposable(): Disposable = apply { disposable.add(this) }
}