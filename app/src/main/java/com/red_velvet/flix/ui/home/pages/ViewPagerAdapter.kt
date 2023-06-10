package com.red_velvet.flix.ui.home.pages

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.red_velvet.flix.ui.home.HomeViewModel

class ViewPagerAdapter(fragment: Fragment, val viewModel: HomeViewModel) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MoviesPageFragment(viewModel)
            1 -> TvShowsPageFragment(viewModel)
            else -> throw IllegalStateException("Invalid position")
        }
    }
}
