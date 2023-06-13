package com.red_velvet.flix.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentHomeBinding
import com.red_velvet.flix.ui.base.BaseFragment
import com.red_velvet.flix.ui.home.pages.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        assignPagesToTabs()
    }

    private fun assignPagesToTabs() {
        val viewPager = view?.findViewById<ViewPager2>(R.id.view_pager)
        viewPager?.adapter = ViewPagerAdapter(this, viewModel)
        viewPager?.isUserInputEnabled = false

        val tabLayout = view?.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout!!, viewPager!!) { tab, position ->
            tab.text = when (position) {
                0 -> "Movies"
                1 -> "TV Shows"
                else -> throw IllegalStateException("Invalid position")
            }
        }.attach()
    }
}


