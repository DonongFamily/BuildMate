package com.fo.buildmate.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.fo.buildmate.databinding.ActivityMainBinding
import com.fo.buildmate.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        initMainBinding()
        initMainViewModel()
    }
    private fun initMainBinding() = with(mBinding) {
        txt.setOnClickListener {
            mainViewModel.getSample()
        }
    }

    private fun initMainViewModel() = with(mainViewModel) {
        errorMessage.observe(this@MainActivity) {
            mBinding.txt.text = it
        }
        sampleData.observe(this@MainActivity) {
            mBinding.txt.text = it.name
        }
    }
}