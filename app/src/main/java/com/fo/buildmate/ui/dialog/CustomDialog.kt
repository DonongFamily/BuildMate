package com.fo.buildmate.ui.dialog

import android.app.ActionBar
import android.app.Application
import android.app.Dialog
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import com.fo.buildmate.databinding.DialogCustomBinding

abstract class CustomDialog(private val context: Context, private val title: String = "", private val content: String = "", private val cancelable: Boolean = true): ICustomDialogClickListener {
    private val dialog = Dialog(context)
    private val mBinding: DialogCustomBinding by lazy { DialogCustomBinding.inflate(LayoutInflater.from(context)) }

    private val width = ActionBar.LayoutParams.MATCH_PARENT
    private val height = ActionBar.LayoutParams.WRAP_CONTENT

    init {
        setContent()
        setButton(mBinding.btnPositive, onPositiveClick())
        setButton(mBinding.btnNegative, onNegativeClick())
        initDialog()
    }

    private fun setContent() = with(mBinding) {
        if(title.isEmpty()) {
            txtTitle.visibility = View.GONE
        }
        txtTitle.text = title
        txtContent.text = content
    }

    private fun setButton(button: Button, action: (() -> Unit)?) {
        if(action == null) {
            button.visibility = View.INVISIBLE
        } else {
            button.setOnClickListener {
                action.invoke()
            }
        }
    }

    private fun initDialog() = with(dialog) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(mBinding.root)
        setCancelable(cancelable)
        window?.setLayout(width, height)
    }

    fun show() {
        dialog.show()
    }
    fun dismiss() {
        dialog.dismiss()
    }

    fun setPositiveButtonText(text: String) {
        mBinding.btnPositive.text = text
    }

    fun setNegativeButtonText(text: String) {
        mBinding.btnNegative.text = text
    }
}
