package com.fo.buildmate.ui.activity

import android.os.Bundle
import android.text.util.Linkify
import android.text.util.Linkify.TransformFilter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fo.buildmate.databinding.ActivityLoginBinding
import com.fo.buildmate.ui.dialog.ConfirmDialog
import com.fo.buildmate.vm.UserViewModel
import com.fo.domain.model.UserRequest
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val mBinding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val userViewModel: UserViewModel by viewModels()

    private val _errorMessage = MutableLiveData<String>()
    private val errorMessage: LiveData<String> = _errorMessage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        initLoginBinding()
        initUserViewModel()

        errorMessage.observe(this@LoginActivity) { message ->
            ConfirmDialog(this@LoginActivity, message).show()
        }
    }

    private fun initLoginBinding() = with(mBinding) {

        val link1: Pattern = Pattern.compile("개인 정보 처리 방침")
        val link2: Pattern = Pattern.compile("이용 약관")
        val mTransform = TransformFilter { _, _ -> "" }
        Linkify.addLinks(txtLink, link1, "http://pingmo.co.kr/user.html", null, mTransform)
        Linkify.addLinks(txtLink, link2, "http://pingmo.co.kr/service.html", null, mTransform)

        // TODO: Login, Logout Logic UUID 가 다름
        btnKakao.setOnClickListener {
            userViewModel.addUserToDB(UserRequest("paul", "1111", "성현", "0"))
        }
        btnGoogle.setOnClickListener { 
            userViewModel.deleteUserToDB(UserRequest("paul", "1111", "성현", "0"))
        }
    }

    private fun initUserViewModel() = with(userViewModel) {
        user.observe(this@LoginActivity) {
            it ?: run {
                //TODO: 로그인 실패
            }
        }
        addUserResult.observe(this@LoginActivity) {
            finish()
        }
        errorMessage.observe(this@LoginActivity) {
            _errorMessage.postValue(it)
        }
    }
}