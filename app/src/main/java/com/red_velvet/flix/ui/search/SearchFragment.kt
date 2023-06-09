package com.red_velvet.flix.ui.search

import android.os.Bundle
import android.transition.ChangeTransform
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
class SearchFragment() : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val layoutIdFragment: Int = R.layout.fragment_search

    override val viewModel: SearchViewModel by viewModels()

    private val oldValue = MutableStateFlow(MediaSearchUiState())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedElementEnterTransition = ChangeTransform()
        val adapter = MediaSearchAdapter(emptyList(), listener = viewModel)
        binding.recyclerSearchResult.adapter = adapter
        getSearchResultsBySearchTerm()
    }

    @OptIn(FlowPreview::class)
    private fun getSearchResultsBySearchTerm() {
        lifecycleScope.launch {
            viewModel.uiState.debounce(500).collectLatest { searchTerm ->
                if (searchTerm.searchInput.isNotBlank()
                    && oldValue.value.searchInput != viewModel.uiState.value.searchInput
                    || oldValue.value.searchTypes != viewModel.uiState.value.searchTypes
                ) {
                    bindMedia()
                    oldValue.emit(viewModel.uiState.value)
                }
            }
        }
    }
    private fun bindMedia() {
        binding.recyclerSearchResult.layoutManager =
            LinearLayoutManager(this@SearchFragment.context, RecyclerView.VERTICAL, false)
    }

}


