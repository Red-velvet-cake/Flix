package com.red_velvet.flix.ui.review

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentReviewDetailsBinding
import com.red_velvet.flix.ui.base.BaseFragment

class ReviewMovieDetailsFragment:BaseFragment<FragmentReviewDetailsBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_review_details
    override val viewModel: ReviewMovieViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}