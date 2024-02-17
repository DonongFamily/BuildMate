package com.fo.buildmate.model

import androidx.fragment.app.Fragment
import com.fo.buildmate.R
import com.fo.buildmate.ui.fragment.SettingFragment

enum class Tab(val title: String, val iconRes: Int, val fragmentClass: Class<out Fragment>) {
    MAIN("메인", R.drawable.home, SettingFragment :: class.java),
    CHATROOM("채팅방", R.drawable.chat, SettingFragment :: class.java),
    SETTING("설정", R.drawable.setting, SettingFragment :: class.java)
}