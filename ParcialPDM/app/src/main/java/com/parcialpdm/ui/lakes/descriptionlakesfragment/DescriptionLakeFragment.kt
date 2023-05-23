package com.parcialpdm.ui.lakes.descriptionlakesfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.parcialpdm.R
import com.parcialpdm.databinding.FragmentDescriptionLakeBinding
import com.parcialpdm.ui.viewmodel.LakeViewModel

class DescriptionLakeFragment : Fragment() {
    private val lakeViewModel: LakeViewModel by activityViewModels {
        LakeViewModel.Factory
    }

    private lateinit var binding: FragmentDescriptionLakeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescriptionLakeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    fun setViewModel() {
        binding.viewmodel = lakeViewModel
    }
}