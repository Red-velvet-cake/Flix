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
    private lateinit var adapter: MovieDetailsAdapter
    private lateinit var similarMovieAdapter: MovieDetailsAdapter
    private lateinit var movieDetailsReviewAdapter: ReviewMovieDetailsAdapter
    private lateinit var movieDetailsImagesAdapter: MovieImagesAdapter
    private lateinit var movieTopCastAdapter: MovieTopCastAdapter
    private lateinit var movieKeywordsAdapter: MovieKeywordsAdapter
    private lateinit var movieCategoriesAdapter: MovieCategoriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieDetailsAdapter(mutableListOf(),viewModel)
        similarMovieAdapter = MovieDetailsAdapter(mutableListOf(),viewModel)
        movieDetailsReviewAdapter = ReviewMovieDetailsAdapter(mutableListOf(),viewModel)
        movieDetailsImagesAdapter = MovieImagesAdapter(mutableListOf(),viewModel)
        movieTopCastAdapter = MovieTopCastAdapter(mutableListOf(),viewModel)
        movieKeywordsAdapter = MovieKeywordsAdapter(mutableListOf(),viewModel)
        movieCategoriesAdapter = MovieCategoriesAdapter(mutableListOf(),viewModel)
        binding.RecommendationsScroll.adapter = adapter
        binding.similarMoviesScroll.adapter = similarMovieAdapter
        binding.reviewsScroll.adapter = movieDetailsReviewAdapter
        binding.ImagesBelongToMovieScroll.adapter = movieDetailsImagesAdapter
        binding.topCastScrollView.adapter = movieTopCastAdapter
        binding.keywordsScrollView.adapter = movieKeywordsAdapter
        binding.movieCategories.adapter = movieCategoriesAdapter
        }
    }