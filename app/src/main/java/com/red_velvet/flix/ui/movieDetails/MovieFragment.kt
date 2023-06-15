package com.red_velvet.flix.ui.movieDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentMovieDetailsBinding
import com.red_velvet.flix.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieDetailsBinding>(){
    override val layoutIdFragment: Int
        get() = R.layout.fragment_movie_details
    override val viewModel: MovieDetailsViewModel by viewModels()
    lateinit var adapter: MovieDetailsAdapter
    private lateinit var similarMovieAdapter: MovieDetailsAdapter
    lateinit var movieDetailsReviewAdapter: ReviewMovieDetailsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieDetailsAdapter(mutableListOf(),viewModel)
        similarMovieAdapter = MovieDetailsAdapter(mutableListOf(),viewModel)
        movieDetailsReviewAdapter = ReviewMovieDetailsAdapter(mutableListOf(),viewModel)
        binding.RecommendationsScroll.adapter = adapter
        binding.similarMoviesScroll.adapter = similarMovieAdapter
        binding.reviewsScroll.adapter = movieDetailsReviewAdapter
        }
    }