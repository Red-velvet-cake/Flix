package com.red_velvet.flix.ui.home

import android.os.Bundle
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
        setTitle(true, "Flix")
        setAdapter()
        collectHomeData()
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter(mutableListOf(), viewModel)
        binding.recyclerView.adapter = homeAdapter
    }


    private fun collectHomeData() {
        val homeItems = mutableListOf<HomeUiState.HomeItem>()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { homeUiState ->
                homeUiState.apply {
                    homeItems.add(HomeUiState.HomeItem("Popular", popularMovies))
                    homeItems.add(HomeUiState.HomeItem("Now Playing", nowPlayingMovies))
                    homeItems.add(HomeUiState.HomeItem("Upcoming", upcomingMovies))
                    homeItems.add(HomeUiState.HomeItem("Top Rated", topRatedMovies))
                }
                homeAdapter.setItems(homeItems)
            }
        }
    }
}