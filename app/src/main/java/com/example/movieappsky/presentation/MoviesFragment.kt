package com.example.movieappsky.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappsky.R
import com.example.movieappsky.presentation.adapter.MoviesAdapter

class MoviesFragment: Fragment() {

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMovies = view.findViewById<RecyclerView>(R.id.rvMovies)
        val rvGenres = view.findViewById<RecyclerView>(R.id.rvGenres)

        moviesAdapter = MoviesAdapter(context = view.context)
        rvMovies.adapter = moviesAdapter

        moviesViewModel = ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)
        moviesViewModel.getMovies()
        progressBar = view.findViewById(R.id.loading)
        observeMovies()
    }

    override fun onResume() {
        super.onResume()
        moviesAdapter.notifyDataSetChanged()
    }

    private fun observeMovies(){
        moviesViewModel.movieListLiveData.observe(viewLifecycleOwner) { result ->
            result?.let {
                moviesAdapter.dataset.clear()
                moviesAdapter.dataset.addAll(it)
                moviesAdapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }
        }
    }
}