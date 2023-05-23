package com.parcialpdm.ui.lakes.homelakesfragment.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parcialpdm.data.model.LakeModel
import com.parcialpdm.databinding.LakeItemBinding

class LakeRecyclerViewAdapter(private val clickListener: (LakeModel) -> Unit)
    : RecyclerView.Adapter<LakeRecyclerViewHolder>(){

    private val lakes = ArrayList<LakeModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LakeRecyclerViewHolder {
        val binding = LakeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LakeRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lakes.size
    }

    override fun onBindViewHolder(holder: LakeRecyclerViewHolder, position: Int) {
        val lake = lakes[position]
        holder.bind(lake, clickListener)
    }

    fun setData(lakeList: List<LakeModel>) {
        lakes.clear()
        lakes.addAll(lakeList)
    }
}