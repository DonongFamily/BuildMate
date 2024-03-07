package com.fo.buildmate.ui.activity

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.fo.buildmate.R
import com.fo.buildmate.base.TabViewAdapter
import com.fo.buildmate.databinding.ActivityMainBinding
import com.fo.buildmate.model.Tab
import com.fo.buildmate.ui.dialog.ConfirmDialog
import com.fo.buildmate.vm.UserViewModel
import com.fo.domain.model.UserDto
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val userViewModel: UserViewModel by viewModels()

    private val _errorMessage = MutableLiveData<String>()
    private val errorMessage: LiveData<String> = _errorMessage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        initMainBinding()
        initUserViewModel()
        initTab()

        errorMessage.observe(this@MainActivity) { message ->
            ConfirmDialog(this@MainActivity, message).show()
        }
    }

    private fun initMainBinding() = with(mBinding) {

    }
    private fun initUserViewModel() = with(userViewModel) {
        user.observe(this@MainActivity) {
            it?.let {
                setUser(it)
            } ?: run {
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        errorMessage.observe(this@MainActivity) {
            _errorMessage.postValue(it)
        }
    }

    private fun setUser(user: UserDto) = with(mBinding.userProfile) {
        txtName.text = user.name
        txtCash.text = user.cash
        Glide.with(this@MainActivity)
            .load(user.imgPath)
            .into(imgUserProfile)
    }


    override fun onStart() {
        super.onStart()
        userViewModel.getUserFromDB()
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
