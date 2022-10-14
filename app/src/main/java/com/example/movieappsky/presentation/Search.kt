package com.example.movieappsky.presentation

import android.os.Parcelable
import com.example.movieappsky.domain.model.Movies
import kotlinx.android.parcel.Parcelize

var searchText = mutableListOf<String>()

@Parcelize
open class Search(): Parcelable {

    open fun addList(X: String): MutableList<String> {
        var exibir = mutableListOf<String>()
        searchText.add(X)
        searchText.sort()
        for(y in searchText) {
            exibir.add(y + "\n" + "\n")
        }
        return exibir //Retorna a lista completa.
    }

    open fun consultList(N: String) : MutableList<Movies> {
        var exibir = mutableListOf<Movies>()
        //searchText.sort()
        for (y in searchText) {
            val nome =
                y.split(" ")
            for (i in nome.indices) {
                if (nome[i] == N) {
                    exibir.plus(y + "\n" + "\n")
                }
            }
        }
        return exibir
    }

    open fun listFull() : MutableList<String> {
        var exibir = mutableListOf<String>()
        searchText.sort()
        for(y in searchText) {
            exibir.add(y + "\n")
        }
        return exibir
    }
}