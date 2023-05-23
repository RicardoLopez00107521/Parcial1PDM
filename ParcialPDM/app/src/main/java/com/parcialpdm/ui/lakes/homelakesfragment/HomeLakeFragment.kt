package com.parcialpdm.ui.lakes.homelakesfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.parcialpdm.R
import com.parcialpdm.data.model.LakeModel
import com.parcialpdm.databinding.FragmentHomeLakeBinding
import com.parcialpdm.ui.lakes.homelakesfragment.recyclerview.LakeRecyclerViewAdapter
import com.parcialpdm.ui.viewmodel.LakeViewModel

class HomeLakeFragment : Fragment() {
    private val lakeViewModel: LakeViewModel by activityViewModels {
        LakeViewModel.Factory
    }

    private lateinit var binding: FragmentHomeLakeBinding
    private lateinit var adapter: LakeRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeLakeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.addLakeButton.setOnClickListener {
            lakeViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeLakeFragment_to_addNewLakeFragment)
        }

    }

    private fun displayMovies() {
        adapter.setData(lakeViewModel.getLakes())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = LakeRecyclerViewAdapter { selectedLake ->
            showSelectedItem(selectedLake)
        }

        binding.RecyclerView.adapter = adapter
        displayMovies()
    }

    private fun showSelectedItem(lake:LakeModel) {
        lakeViewModel.setSelectedLake(lake)
        findNavController().navigate(R.id.action_homeLakeFragment_to_descriptionLakeFragment)
    }
}