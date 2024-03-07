package com.fo.buildmate.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fo.buildmate.base.MaterialRecyclerViewAdapter
import com.fo.buildmate.databinding.FragmentHomeBinding
import com.fo.buildmate.ui.dialog.ConfirmDialog
import com.fo.buildmate.vm.MaterialViewModel
import com.fo.domain.model.MaterialRequest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var mBinding: FragmentHomeBinding? = null
    private val materialViewModel: MaterialViewModel by activityViewModels()

    private val _errorMessage = MutableLiveData<String>()
    private val errorMessage: LiveData<String> = _errorMessage

    private val materialRecyclerViewAdapter: MaterialRecyclerViewAdapter by lazy {
        MaterialRecyclerViewAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)

        initHomeFragmentBinding()
        initMaterialViewModel()
        errorMessage.observe(viewLifecycleOwner) { message ->
            context?.let { ConfirmDialog(it, message).show() }
        }

        return mBinding?.root
    }

    private fun initHomeFragmentBinding() = with(mBinding) {
        this?.let {
            viewMaterial.adapter = materialRecyclerViewAdapter
            viewMaterial.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            val dividerItemDecoration = DividerItemDecoration(viewMaterial.context, LinearLayoutManager.VERTICAL)
            viewMaterial.addItemDecoration(dividerItemDecoration)

            btnCategory.setOnClickListener {
                val categoriesBottomSheetDialogFragment = FilterCategoryFragment()
                categoriesBottomSheetDialogFragment.show(childFragmentManager, categoriesBottomSheetDialogFragment.tag)
            }
            swipeRefreshLayout.setOnRefreshListener {
                lifecycleScope.launch {
                    delay(1000)
                    materialViewModel.getMaterialList(MaterialRequest("d"))
                    swipeRefreshLayout.isRefreshing = false
                }
            }
        }
    }

    private fun initMaterialViewModel() = with(materialViewModel) {
        errorMessage.observe(viewLifecycleOwner) {
            _errorMessage.postValue(it)
        }
        materialList.observe(viewLifecycleOwner) {
            materialRecyclerViewAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null

    }
}