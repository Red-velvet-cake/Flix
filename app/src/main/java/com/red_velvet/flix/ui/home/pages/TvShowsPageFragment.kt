package com.red_velvet.flix.ui.home.pages

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.TvshowsPageBinding
import com.red_velvet.flix.ui.base.BaseFragment
import com.red_velvet.flix.ui.home.MovieUiState
import com.red_velvet.flix.ui.home.HomeViewModel
import com.red_velvet.flix.ui.home.TvShowUiState
import com.red_velvet.flix.ui.home.adapter.MovieAdapter
import com.red_velvet.flix.ui.home.adapter.TvShowAdapter
import kotlinx.coroutines.launch

class TvShowsPageFragment(override val viewModel: HomeViewModel) :
    BaseFragment<TvshowsPageBinding>() {
    override val layoutIdFragment = R.layout.tvshows_page
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        collectTvShowData()
    }

    private fun setAdapter() {
        tvShowAdapter = TvShowAdapter(mutableListOf(), viewModel)
        binding.tvshowsRecyclerView.adapter = tvShowAdapter
    }

    private fun collectTvShowData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.tvShowState.collect { tvshowUiState ->
                tvShowAdapter.setItems(
                    mutableListOf(
                        TvShowUiState.TvShowItem("Popular Series", tvshowUiState.popularSeries),
                        TvShowUiState.TvShowItem("Airing Today", tvshowUiState.airingTodaySeries),
                        TvShowUiState.TvShowItem("On TV", tvshowUiState.onTVSeries),
                        TvShowUiState.TvShowItem("Top Rated", tvshowUiState.topRatedSeries),
                    )
                )
            }
        }
    }


}
