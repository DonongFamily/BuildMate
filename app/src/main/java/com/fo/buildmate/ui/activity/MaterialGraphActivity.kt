package com.fo.buildmate.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fo.buildmate.databinding.ActivityMaterialGraphBinding
import com.fo.buildmate.ui.dialog.ConfirmDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MaterialGraphActivity : AppCompatActivity() {

    private val mBinding: ActivityMaterialGraphBinding by lazy { ActivityMaterialGraphBinding.inflate(layoutInflater) }

    private val _errorMessage = MutableLiveData<String>()
    private val errorMessage: LiveData<String> = _errorMessage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        initMaterialGraphBinding()

        errorMessage.observe(this@MaterialGraphActivity) { message ->
            ConfirmDialog(this@MaterialGraphActivity, message).show()
        }
    }

    private fun initMaterialGraphBinding() = with(mBinding) {

    }
}
