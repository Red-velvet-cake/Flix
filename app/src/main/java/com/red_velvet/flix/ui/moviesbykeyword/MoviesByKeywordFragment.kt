package com.red_velvet.flix.ui.moviesbykeyword

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentMoviesByKeywordBinding
import com.red_velvet.flix.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesByKeywordFragment : BaseFragment<FragmentMoviesByKeywordBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_movies_by_keyword
    override val viewModel: KeywordViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        navigateTo()
    }

    private fun setAdapter() {
        val adapter = MoviesKeywordAdapter(emptyList(), viewModel)
        binding.recyclerView.adapter = adapter
    }

    private fun navigateTo() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiEvent.collect { event ->
                when (event) {
                    is UIEventMoviesByKeyword.NavigateToMovieDetail -> {
                        Log.d("navigateTo ", ": $event ")
                        val action = MoviesByKeywordFragmentDirections.actionMoviesByKeywordFragmentToLoginFragment()
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }
}