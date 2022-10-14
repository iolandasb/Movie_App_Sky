package com.example.movieappsky.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movieappsky.presentation.MoviesFragment

class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 1
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            ALL_MOVIES_POSITION -> MoviesFragment()
            else -> MoviesFragment()
        }
    }

    companion object {
        const val ALL_MOVIES_POSITION = 0
    }
}