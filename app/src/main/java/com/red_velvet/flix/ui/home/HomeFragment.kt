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
        setAdapter()
        collectHomeData()
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter(mutableListOf(), viewModel)
        binding.recyclerView.adapter = homeAdapter
    }

//    private fun collectHomeData() {
//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.state.collect { homeUiState ->
//                val homeItems = mutableListOf<HomeItem>()
//                Log.i("HomeFragment", "homeUiState: $homeUiState")
//
//                homeUiState?.popularMovies?.let { popularMovies ->
//                    Log.i("HomeFragment", "popularMovies: $popularMovies")
//                    homeItems.add(HomeItem.Popular(popularMovies))
//                }
//                homeUiState?.nowPlayingMovies?.let { nowPlayingMovies ->
//                    Log.i("HomeFragment", "nowPlayingMovies: $nowPlayingMovies")
//
//                    homeItems.add(HomeItem.NowPlaying(nowPlayingMovies))
//                }
//                homeUiState?.upcomingMovies?.let { upcomingMovies ->
//                    Log.i("HomeFragment", "upcomingMovies: $upcomingMovies")
//
//                    homeItems.add(HomeItem.Upcoming(upcomingMovies))
//                }
//                homeUiState?.topRatedMovies?.let { topRatedMovies ->
//                    Log.i("HomeFragment", "topRatedMovies: $topRatedMovies")
//
//                    homeItems.add(HomeItem.TopRated(topRatedMovies))
//                }
//                homeAdapter.setItems(homeItems)
//            }
//        }
//    }

    private fun collectHomeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { homeUiState ->
                val homeItems = mutableListOf<HomeUiState.HomeItem>()
                homeUiState?.popularMovies?.let { popularMovies ->
                    homeItems.add(HomeUiState.HomeItem("Popular", popularMovies))
                }
                homeUiState?.nowPlayingMovies?.let { nowPlayingMovies ->
                    homeItems.add(HomeUiState.HomeItem("Now Playing", nowPlayingMovies))
                }
                homeUiState?.upcomingMovies?.let { upcomingMovies ->
                    homeItems.add(HomeUiState.HomeItem("Upcoming", upcomingMovies))
                }
                homeUiState?.topRatedMovies?.let { topRatedMovies ->
                    homeItems.add(HomeUiState.HomeItem("Top Rated", topRatedMovies))
                }
                homeAdapter.setItems(homeItems)
            }
        }
    }

//    private fun collectHomeData() {
//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.state.collect {
//                homeAdapter.setItems(
//                    mutableListOf(
//                        it.popularMovies,
//                        it.nowPlayingMovies,
//                        it.upcomingMovies,
//                        it.topRatedMovies,
//                    )
//                )
//            }
//        }
//    }
}