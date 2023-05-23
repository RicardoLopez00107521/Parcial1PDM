package com.parcialpdm.ui

import android.app.Application
import com.parcialpdm.data.lakes
import com.parcialpdm.repository.LakeRepository

class LakeReviewerApplication: Application() {
    val lakeRepository: LakeRepository by lazy {
        LakeRepository(lakes)
    }
}