package com.fo.buildmate.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fo.buildmate.model.Tab

class TabViewAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm,
    lifecycle
){
    private val tabList = Tab.values()
    private val fragments by lazy { tabList.map { it.fragmentClass.newInstance() } }

    fun getPageTitle(position: Int): CharSequence = tabList[position].title

    fun getPageIcon(position: Int): Int = tabList[position].iconRes

    override fun getItemCount(): Int = tabList.size

    override fun createFragment(p0: Int): Fragment = fragments[p0]

}