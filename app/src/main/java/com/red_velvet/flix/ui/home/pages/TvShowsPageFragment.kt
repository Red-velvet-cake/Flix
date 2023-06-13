package com.red_velvet.flix.ui.home.pages

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.TvshowsPageBinding
import com.red_velvet.flix.ui.base.BaseFragment
import com.red_velvet.flix.ui.home.HomeUiState
import com.red_velvet.flix.ui.home.HomeViewModel
import com.red_velvet.flix.ui.home.adapters.TvShowsAdapter
import kotlinx.coroutines.launch

class TvShowsPageFragment(override val viewModel: HomeViewModel) :
    BaseFragment<TvshowsPageBinding>() {
    override val layoutIdFragment = R.layout.tvshows_page
    private lateinit var tvShowAdapter: TvShowsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        collectTvShowData()
    }

    private fun setAdapter() {
        tvShowAdapter = TvShowsAdapter(mutableListOf(), viewModel)
        binding.tvshowsRecyclerView.adapter = tvShowAdapter
    }

    private fun collectTvShowData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { tvshowUiState ->
                tvShowAdapter.setItems(
                    mutableListOf(
                        HomeUiState.HomeItem("Popular Series", tvshowUiState.popularSeries),
                        HomeUiState.HomeItem("Airing Today", tvshowUiState.airingTodaySeries),
                        HomeUiState.HomeItem("On TV", tvshowUiState.onTVSeries),
                        HomeUiState.HomeItem("Top Rated", tvshowUiState.topRatedSeries),
                    )
                )
            }
        }
    }


}
