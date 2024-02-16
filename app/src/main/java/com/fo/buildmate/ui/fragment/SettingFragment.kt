package com.fo.buildmate.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fo.buildmate.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private var fragmentSettingBinding: FragmentSettingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSettingBinding = FragmentSettingBinding.inflate(inflater, container, false)

        return fragmentSettingBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentSettingBinding = null
    }
}
