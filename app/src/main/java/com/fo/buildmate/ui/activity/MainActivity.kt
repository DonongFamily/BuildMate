package com.fo.buildmate.ui.activity

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.fo.buildmate.R
import com.fo.buildmate.base.TabViewAdapter
import com.fo.buildmate.databinding.ActivityMainBinding
import com.fo.buildmate.model.Tab
import com.fo.buildmate.vm.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val materialViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        initMainBinding()
        initMaterialViewModel()
        initTab()
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun initMainBinding() = with(mBinding) {

    }
    private fun initMaterialViewModel() = with(materialViewModel) {

    }

    private fun initTab() {
        val adapter = TabViewAdapter(supportFragmentManager, lifecycle)
        mBinding.apply {

            pager.adapter = adapter
            TabLayoutMediator(tab, pager) {
                    tabLayout, position ->
                tabLayout.setIcon(adapter.getPageIcon(position))
                tabLayout.text = adapter.getPageTitle(position)
            }.attach()
            pager.offscreenPageLimit = Tab.values().size
        }

        mBinding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(p0: TabLayout.Tab?) {
                p0?.icon?.setColorFilter(ContextCompat.getColor(applicationContext,  androidx.appcompat.R.color.material_blue_grey_800), PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                p0?.icon?.setColorFilter(ContextCompat.getColor(applicationContext, R.color.white), PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {}
        })
    }
}
