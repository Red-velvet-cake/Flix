package com.red_velvet.flix.ui.home.pages

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.MoviesPageBinding
import com.red_velvet.flix.ui.base.BaseFragment
import com.red_velvet.flix.ui.home.HomeUiState
import com.red_velvet.flix.ui.home.HomeViewModel
import com.red_velvet.flix.ui.home.adapter.MovieAdapter
import kotlinx.coroutines.launch


class MoviesPageFragment(override val viewModel: HomeViewModel) :
    BaseFragment<MoviesPageBinding>() {
    override val layoutIdFragment = R.layout.movies_page
    private lateinit var moviesAdapter: MovieAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        collectMovieData()
    }

    private fun setAdapter() {
        moviesAdapter = MovieAdapter(mutableListOf(), viewModel)
        binding.moviesRecyclerView.adapter = moviesAdapter
    }

    private fun collectMovieData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { moviesUiState ->
                moviesAdapter.setItems(
                    mutableListOf(
                        HomeUiState.HomeItem("Popular Movies", moviesUiState.popularMovies),
                        HomeUiState.HomeItem("Now Playing", moviesUiState.nowPlayingMovies),
                        HomeUiState.HomeItem("Upcoming", moviesUiState.upcomingMovies),
                        HomeUiState.HomeItem("Top Rated", moviesUiState.topRatedMovies),
                    )
                )
            }
        }
    }
}

