package com.example.movieappsky.presentation

import com.example.movieappsky.domain.model.Movies

interface ClickListener {
    fun onClickListener(item: List<Movies>, position: Int)
}