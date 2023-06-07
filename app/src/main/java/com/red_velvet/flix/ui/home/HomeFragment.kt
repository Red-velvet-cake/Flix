package com.red_velvet.flix.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentHomeBinding
import com.red_velvet.flix.ui.base.BaseFragment
import com.red_velvet.flix.ui.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel, HomeUiState>() {
    override val layoutIdFragment = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, "Flix Movie")
        setAdapter()
        collectHomeData()
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter(mutableListOf(), viewModel)
        binding.recyclerView.adapter = homeAdapter
    }


    private fun collectHomeData() {
        var homeItems: MutableList<HomeUiState.HomeItem>
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { homeUiState ->
                homeUiState.apply {
                    homeItems = mutableListOf(
                        HomeUiState.HomeItem("Popular", popularMovies),
                        HomeUiState.HomeItem("Now Playing", nowPlayingMovies),
                        HomeUiState.HomeItem("Upcoming", upcomingMovies),
                        HomeUiState.HomeItem("Top Rated", topRatedMovies),
                    )
                }
                homeAdapter.setItems(homeItems)
            }
        }
    }
}