package com.fo.buildmate.ui.dialog

import android.app.Activity
import android.content.Context

class ConfirmDialog(private val context: Context, content: String = "", private val finishActivity: Boolean = false):
    CustomDialog(context,
        content = content,
        cancelable = false) {

    override fun onPositiveClick(): () -> Unit = {
        dismiss()
        if (finishActivity && context is Activity) {
            context.finish()
        }
    }
}