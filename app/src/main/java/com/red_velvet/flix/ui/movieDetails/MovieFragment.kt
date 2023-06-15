package com.red_velvet.flix.ui.movieDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentMovieDetailsBinding
import com.red_velvet.flix.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieDetailsBinding>(){
    override val layoutIdFragment: Int
        get() = R.layout.fragment_movie_details
    override val viewModel: MovieDetailsViewModel by viewModels()
    lateinit var adapter: MovieDetailsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieDetailsAdapter(mutableListOf(),viewModel)
        binding.RecommendationsScroll.adapter = adapter
    }
}