package com.red_velvet.flix.ui.review

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentReviewBinding
import com.red_velvet.flix.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewMovieFragment : BaseFragment<FragmentReviewBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_review
    override val viewModel: ReviewMovieViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewMovieReview.adapter = ReviewAdapter(emptyList(), viewModel)
    }
}