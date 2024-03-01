package com.fo.buildmate.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.fo.buildmate.databinding.FragmentFilterCategoryBinding
import com.fo.buildmate.vm.MaterialViewModel
import com.fo.domain.model.MaterialRequest
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterCategoryFragment : BottomSheetDialogFragment() {

    private var mBinding: FragmentFilterCategoryBinding? = null
    private val materialViewModel: MaterialViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 여기에 fragment_categories_bottom_sheet.xml 레이아웃을 인플레이트
        mBinding = FragmentFilterCategoryBinding.inflate(inflater, container, false)
        mBinding?.apply {
            txtCategory1.setOnClickListener {
                materialViewModel.getMaterialList(MaterialRequest("hi"))
            }
            txtCategory2.setOnClickListener {
                materialViewModel.getMaterialList(MaterialRequest(""))
            }
        }
        return mBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}