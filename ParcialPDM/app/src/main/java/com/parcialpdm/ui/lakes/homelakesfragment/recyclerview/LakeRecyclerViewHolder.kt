package com.parcialpdm.ui.lakes.homelakesfragment.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.parcialpdm.data.model.LakeModel
import com.parcialpdm.databinding.LakeItemBinding

class LakeRecyclerViewHolder (private val binding: LakeItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(lake: LakeModel, clickListener: (LakeModel) -> Unit) {
        binding.lakeNameItem.text = lake.name
        binding.lakeSurfaceItem.text = lake.surface

        binding.lakeItemCardView.setOnClickListener {
            clickListener(lake)
        }
    }
}