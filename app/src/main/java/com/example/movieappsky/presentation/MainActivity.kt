package com.example.movieappsky.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.example.movieappsky.R
import com.example.movieappsky.databinding.ActivityMainBinding
import com.example.movieappsky.presentation.adapter.MoviesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moviesAdapter = MoviesAdapter(context = this)
        moviesViewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        setUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val search: MenuItem? = menu?.findItem(R.id.itSearch)
        val searchView: SearchView = search?.actionView as SearchView
        searchView.queryHint = "Search by title or genre"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                moviesAdapter.getFilter().filter(newText) {
                    newText
                }
                if (newText.equals("")) {
                    setUp()
                }
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun setUp() {
        binding.rvMovies.adapter = moviesAdapter
        moviesViewModel.getMovies()
        observeMovies()
    }

    private fun observeMovies() {
        moviesViewModel.movieListLiveData.observe(this) { result ->
            result?.let {
                moviesAdapter.dataset.clear()
                moviesAdapter.dataset.addAll(it)
                moviesAdapter.notifyDataSetChanged()
            }
        }
    }
}