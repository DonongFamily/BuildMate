package com.fo.buildmate.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fo.buildmate.databinding.FragmentChatRoomBinding

class ChatRoomFragment : Fragment() {

    private var mBinding: FragmentChatRoomBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentChatRoomBinding.inflate(inflater, container, false)

        return mBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}
