package com.red_velvet.flix.ui.movieDetails

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
}