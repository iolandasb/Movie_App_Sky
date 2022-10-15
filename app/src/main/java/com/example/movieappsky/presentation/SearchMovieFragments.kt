package com.example.movieappsky.presentation

import android.content.Intent
import android.graphics.Movie
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappsky.R
import com.example.movieappsky.presentation.adapter.MoviesAdapter

//class SearchMovieFragments : Fragment() {
//
//    private var movieSearched: String? = null
//    private lateinit var moviesAdapter: MoviesAdapter
//    private lateinit var progressBar: ProgressBar
//    private lateinit var movieNotFound: View
//    private lateinit var rvMovies: RecyclerView
//    private var moviesViewModel = MoviesViewModel()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            movieSearched = it.getString(ARG_PARAM1)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_movies, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        rvMovies = view.findViewById(R.id.rvMovies)
//
//        progressBar = view.findViewById(R.id.loading)
//        progressBar.visibility = View.VISIBLE
//
//        moviesAdapter = MoviesAdapter(context = view.context)
//        rvMovies.adapter = moviesAdapter
//
//        updateQuery()
//
//        observeMovies()
//        progressBar.visibility = View.GONE
//    }
//
//    private fun updateQuery() {
//        observeMovies()
//        movieNotFound.visibility = View.GONE
//    }
//
//    private fun observeMovies() {
//        moviesViewModel.movieListLiveData.observe(viewLifecycleOwner) { result ->
//            result?.let {
//                rvMovies.visibility = View.VISIBLE
//                moviesAdapter.dataset.clear()
//                moviesAdapter.dataset.addAll(it)
//                moviesAdapter.notifyDataSetChanged()
//            }
//        }
//    }
//
//    companion object {
//        private const val ARG_PARAM1 = "movieSearched"
//
//        @JvmStatic
//        fun newInstance(movieSearched: String) =
//            SearchMovieFragments().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, movieSearched)
//                }
//            }
//    }
//}