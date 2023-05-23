package com.parcialpdm.data

import com.parcialpdm.data.model.LakeModel

val name = "Lago de Coatepeque"
val surface = "25.9"

val name2 = "Lago de Ilopango"
val surface2 = "72"

var lakes = mutableListOf(
    LakeModel(name, surface),
    LakeModel(name2, surface2)
)
