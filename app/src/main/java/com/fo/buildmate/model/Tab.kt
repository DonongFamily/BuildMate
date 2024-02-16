package com.fo.buildmate.model

import androidx.fragment.app.Fragment
import com.fo.buildmate.R
import com.fo.buildmate.ui.fragment.SettingFragment

enum class Tab(val title: String, val iconRes: Int, val fragmentClass: Class<out Fragment>) {
    IN_PATIENT("메인", R.drawable.home, SettingFragment :: class.java),
    OUT_PATIENT("채팅방", R.drawable.chat, SettingFragment :: class.java),
    TODO_PATIENT("설정", R.drawable.setting, SettingFragment :: class.java)
}