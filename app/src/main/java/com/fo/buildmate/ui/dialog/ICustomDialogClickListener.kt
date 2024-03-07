package com.fo.buildmate.ui.dialog

interface ICustomDialogClickListener {
    fun onPositiveClick(): (() -> Unit)? = null
    fun onNegativeClick(): (() -> Unit)? = null
}