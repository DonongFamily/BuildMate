package com.fo.buildmate.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fo.buildmate.databinding.FragmentFilterCategoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterCategoryFragment : BottomSheetDialogFragment() {

    private var mBinding: FragmentFilterCategoryBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 여기에 fragment_categories_bottom_sheet.xml 레이아웃을 인플레이트
        mBinding = FragmentFilterCategoryBinding.inflate(inflater, container, false)
        return mBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}