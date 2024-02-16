package com.fo.buildmate.ui.activity

import android.os.Bundle
import android.text.util.Linkify
import android.text.util.Linkify.TransformFilter
import androidx.appcompat.app.AppCompatActivity
import com.fo.buildmate.databinding.ActivityLoginBinding
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {

    private val mBinding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)


        val link1: Pattern = Pattern.compile("개인 정보 처리 방침")
        val link2: Pattern = Pattern.compile("이용 약관")
        val mTransform = TransformFilter { match, url -> "" }
        Linkify.addLinks(mBinding.txtLink, link1, "http://pingmo.co.kr/user.html", null, mTransform)
        Linkify.addLinks(mBinding.txtLink, link2, "http://pingmo.co.kr/service.html", null, mTransform)

        mBinding.btnKakao.setOnClickListener {
            finish()
        }
    }
}