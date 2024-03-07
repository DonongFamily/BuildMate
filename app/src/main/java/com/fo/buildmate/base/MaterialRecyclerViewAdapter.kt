package com.fo.buildmate.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fo.buildmate.databinding.ItemMaterialBinding
import com.fo.domain.model.MaterialDto

class MaterialRecyclerViewAdapter : RecyclerView.Adapter<MaterialRecyclerViewAdapter.MaterialRecyclerViewHolder>() {
    private var mList: List<MaterialDto> = emptyList()
    private var filteredList: List<MaterialDto> = emptyList()

    fun submitList(list: List<MaterialDto>) {
        mList = list
        filteredList = list
        notifyDataSetChanged()
    }

    fun filter(condition: (MaterialDto) -> Boolean) {
        filteredList = mList.filter(condition)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialRecyclerViewHolder {
        val mBinding = ItemMaterialBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MaterialRecyclerViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: MaterialRecyclerViewHolder, position: Int) {
        holder.bind(filteredList[position])
    }

    override fun getItemCount(): Int = filteredList.size

    class MaterialRecyclerViewHolder(private val mBinding: ItemMaterialBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(item: MaterialDto) {
            mBinding.apply {
                root.setOnClickListener {
                    
                }
                txtName.text = item.name
                txtDetail.text = item.detail
                txtPrice.text = item.price.toString()
            }
        }
    }
}
