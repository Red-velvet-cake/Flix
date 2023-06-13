package com.red_velvet.flix.ui.search

import android.os.Bundle
import android.transition.ChangeTransform
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentSearchBinding
import com.red_velvet.flix.ui.base.BaseFragment
import com.red_velvet.flix.ui.search.adapter.MediaSearchAdapter
import com.red_velvet.flix.ui.search.mediaSearchUiState.MediaSearchUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment() : BaseFragment<FragmentSearchBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_search

    override val viewModel: SearchViewModel by viewModels()

    private val oldValue = MutableStateFlow(MediaSearchUiState())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedElementEnterTransition = ChangeTransform()
        getSearchResultsBySearchTerm()
        setAdapter()
    }

    private fun setAdapter() {
        val adapter = MediaSearchAdapter(emptyList(), listener = viewModel)
        binding.recyclerSearchResult.adapter = adapter
    }

    @OptIn(FlowPreview::class)
    private fun getSearchResultsBySearchTerm() {
        lifecycleScope.launch {
            viewModel.state.debounce(500).collectLatest { searchTerm ->
                if (searchTerm.searchInput.isNotBlank()
                    && oldValue.value.searchInput != viewModel.state.value.searchInput
                    || oldValue.value.searchTypes != viewModel.state.value.searchTypes
                ) {
                    bindMedia()
                    oldValue.emit(viewModel.state.value)
                }
            }
        }
    }

    private fun bindMedia() {
        binding.recyclerSearchResult.layoutManager =
            StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
    }

}


