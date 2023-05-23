package com.parcialpdm.ui.lakes.addnewlake

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.parcialpdm.R
import com.parcialpdm.databinding.FragmentAddNewLakeBinding
import com.parcialpdm.ui.viewmodel.LakeViewModel

class AddNewLakeFragment : Fragment() {
    private val lakeViewModel: LakeViewModel by activityViewModels{
        LakeViewModel.Factory
    }

    private lateinit var binding: FragmentAddNewLakeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNewLakeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = lakeViewModel
    }

    private fun observeStatus() {
        lakeViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(LakeViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    lakeViewModel.clearStatus()
                }
                status.equals(LakeViewModel.LAKE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, lakeViewModel.getLakes().toString())

                    lakeViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object {
        const val APP_TAG = "APP_TAG"
    }
}