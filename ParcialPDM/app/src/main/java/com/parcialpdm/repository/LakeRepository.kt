package com.parcialpdm.repository

import com.parcialpdm.data.model.LakeModel

class LakeRepository(private val lakes: MutableList<LakeModel>) {

    fun getLakes() = lakes

    fun addLakes(lake:LakeModel) = lakes.add(lake)
}