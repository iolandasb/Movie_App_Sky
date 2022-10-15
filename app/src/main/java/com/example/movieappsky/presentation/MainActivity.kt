package com.example.movieappsky.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappsky.R
import com.example.movieappsky.domain.model.Movies
import com.example.movieappsky.presentation.adapter.MoviesAdapter

//import com.example.movieappsky.presentation.adapter.ViewPagerAdapter
//import com.example.movieappsky.presentation.adapter.ViewPagerAdapter.Companion.ALL_MOVIES_POSITION

class MainActivity : AppCompatActivity(), ClickListener
{

    //    private var searchEdtTxt: EditText? = null
//    private lateinit var searchBtn: ImageButton
//    private lateinit var greenIcon: ImageView
//    private lateinit var searchModeTxt: TextView
//    private lateinit var backToHomeBtn: TextView
//    private lateinit var tbLytOptions: TabLayout
//    private lateinit var viewPager: ViewPager2
//    private lateinit var fragmentContainer: FrameLayout
//    private lateinit var movieSearched: String
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var moviesViewModel: MoviesViewModel

    //    private lateinit var search: MenuItem?
    private lateinit var searchView: SearchView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    //private var searchFragment: SearchMovieFragments? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        bindViews()
        moviesAdapter = MoviesAdapter(context = this)
        moviesViewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        val rvMovies = findViewById<RecyclerView>(R.id.rvMovies)
        rvMovies.adapter = moviesAdapter
        moviesViewModel.getMovies()
        observeMovies()
//        toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.search_menu, menu)

        val search: MenuItem? = menu?.findItem(R.id.itSearch)
        val searchView: SearchView = search?.actionView as SearchView
//        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
//        searchView.isSubmitButtonEnabled
//        searchView.queryHint = "Search"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean
            {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean
            {
                moviesAdapter.getFilter().filter(newText) {
                    newText.toBoolean()
                }
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun observeMovies()
    {
        moviesViewModel.movieListLiveData.observe(this) { result ->
            result?.let {
                moviesAdapter.dataset.clear()
                moviesAdapter.dataset.addAll(it)
                moviesAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onClickListener(item: List<Movies>, position: Int)
    {
        moviesViewModel.getMovies()
    }

}

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.search_menu, menu)
//
//        val search: MenuItem? = menu?.findItem(R.id.icSearch)
//        val searchView: SearchView = search?.actionView as SearchView
//        searchView.queryHint = "Search"
//
//        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                moviesAdapter.dataset.filter {
//                    newText.toBoolean()
//                }
//                return true
//            }
//        })
//        return super.onCreateOptionsMenu(menu)
//    }

//        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                moviesAdapter.dataset.filter {
//                    newText.toBoolean()
//                }
//                return true
//            }
//        })
//        return super.onCreateOptionsMenu(menu)
//    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.search_menu, menu)
//
//        val search: MenuItem? = menu?.findItem(R.id.icSearch)
//        val searchView: SearchView = search?.actionView as SearchView
//        searchView.queryHint = "Search"
//
//        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                moviesAdapter.dataset.filter {
//                    newText.toBoolean()
//                }
//                return true
//            }
//        })
//        return super.onCreateOptionsMenu(menu)
//    }

//private fun bindViews() {
//        searchEdtTxt = findViewById(R.id.searchMovie)
//        searchBtn = findViewById(R.id.submitSearch)
//        tbLytOptions = findViewById(R.id.tabLytOptions)
//        viewPager = findViewById(R.id.viewPager)
//        greenIcon = findViewById(R.id.greenIcon)
//        searchModeTxt = findViewById(R.id.searchModeTxt)
//        backToHomeBtn = findViewById(R.id.backToHomeBtn)
//        fragmentContainer = findViewById(R.id.searchFragmentContainer)
//        search = findViewById(R.id.icSearch)
//        searchView = search?.actionView as SearchView

//        viewPager.adapter = ViewPagerAdapter(this)
//        viewPager.isUserInputEnabled = false
//        TabLayoutMediator(tbLytOptions, viewPager) { tab, position ->
//            tab.text = getTabTitle(position)
//        }.attach()

//        searchEdtTxt?.setOnEditorActionListener { _, actionId, _ ->
//            when(actionId) {
//                EditorInfo.IME_ACTION_SEARCH -> {
//                    movieSearched = searchEdtTxt?.text.toString()
//                    if(searchFragment == null) {
//                        searchFragment = SearchMovieFragments.newInstance(movieSearched)
//                        searchFragment?.let{
//                            supportFragmentManager.beginTransaction()
//                                .replace(R.id.searchFragmentContainer, it)
//                                .commit()
//                        }
//                    }
//                    else {
//                        searchFragment
//                    }
//                    true}
//                else -> false
//            }
//        }

//        val search = Search()
//
//        searchBtn.setOnClickListener {
//            val textSearched = searchEdtTxt?.text.toString()
//            if (textSearched.isNotEmpty()) {
//                //if (search.consultList(textSearched).isNotEmpty()) {
//                if (moviesAdapter.dataset.isNotEmpty()) {
//                    moviesAdapter.updateList(search.consultList(textSearched))
//                    searchEdtTxt?.text = null
//                } else {
//                    Toast.makeText(
//                        this,
//                        "Could not found",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            } else searchEdtTxt?.error = "Error"
//        }
//
//        searchEdtTxt?.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                visibilitySearchMode()
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                if (s != null) {
//                    if (s.isEmpty()) {
//                        viewPager.setCurrentItem(ALL_MOVIES_POSITION, false)
//                        visibilityNotSearchMode()
//                    }
//                }
//            }
//        })
//
//        backToHomeBtn.setOnClickListener {
//            visibilityNotSearchMode()
//            searchEdtTxt?.text?.clear()
//        }
//    }
//
//    private fun getTabTitle(position: Int): String {
//        return when (position) {
//            ALL_MOVIES_POSITION -> "Movies"
//            else -> ""
//        }
//    }
//
//    private fun visibilitySearchMode() {
//        tbLytOptions.visibility = View.GONE
//        viewPager.visibility = View.GONE
//        greenIcon.visibility = View.VISIBLE
//        searchModeTxt.visibility = View.VISIBLE
//        backToHomeBtn.visibility = View.VISIBLE
//        fragmentContainer.visibility = View.VISIBLE
//    }
//
//    private fun visibilityNotSearchMode() {
//        tbLytOptions.visibility = View.VISIBLE
//        viewPager.visibility = View.VISIBLE
//        fragmentContainer.visibility = View.GONE
//        greenIcon.visibility = View.GONE
//        searchModeTxt.visibility = View.GONE
//        backToHomeBtn.visibility = View.GONE
//    }
//}