package com.red_velvet.flix.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentHomeBinding
import com.red_velvet.flix.ui.base.BaseFragment
import com.red_velvet.flix.ui.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
//        collectHomeData()
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter(mutableListOf(), viewModel)
        binding.recyclerView.adapter = homeAdapter
    }

//    private fun collectHomeData() {
//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.homeUiState.collect {
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