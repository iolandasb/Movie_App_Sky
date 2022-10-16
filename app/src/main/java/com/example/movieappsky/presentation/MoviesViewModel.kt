package com.example.movieappsky.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappsky.domain.model.Movies
import com.example.movieappsky.domain.usecase.GetMoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MoviesViewModel: ViewModel() {

    private val getMoviesUseCase = GetMoviesUseCase()

    private val _moviesLiveData = MutableLiveData<List<Movies>>(mutableListOf())
    val movieListLiveData : LiveData<List<Movies>> = _moviesLiveData

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

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    private fun Disposable.handleDisposable(): Disposable = apply { disposable.add(this) }
}