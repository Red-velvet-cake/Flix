package com.red_velvet.flix.ui.home.pages

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.TvshowsPageBinding
import com.red_velvet.flix.ui.base.BaseFragment
import com.red_velvet.flix.ui.home.HomeUiState
import com.red_velvet.flix.ui.home.HomeViewModel
import com.red_velvet.flix.ui.home.adapter.HomeAdapter
import kotlinx.coroutines.launch

class TvShowsPageFragment(override val viewModel: HomeViewModel) : BaseFragment<TvshowsPageBinding>() {
    override val layoutIdFragment = R.layout.tvshows_page
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        collectTvShowData()
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter(mutableListOf(), viewModel)
        binding.tvshowsRecyclerView.adapter = homeAdapter
    }

    private fun collectTvShowData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { homeUiState ->
                homeAdapter.setItems(
                    mutableListOf(
                        HomeUiState.HomeItem("Popular", homeUiState.popularMovies),
                        HomeUiState.HomeItem("Now Playing", homeUiState.nowPlayingMovies),
                        HomeUiState.HomeItem("Upcoming", homeUiState.upcomingMovies),
                        HomeUiState.HomeItem("Top Rated", homeUiState.topRatedMovies),
                    )
                )
            }
        }
    }


}
