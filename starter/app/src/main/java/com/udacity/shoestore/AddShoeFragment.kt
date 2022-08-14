package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class AddShoeFragment : Fragment() {

    private val shoesViewModel: ShoesListViewModel by activityViewModels()
    private lateinit var addShoeViewModel: AddShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentAddShoeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_shoe,
            container,
            false
        )

        addShoeViewModel = ViewModelProvider(this)[AddShoeViewModel::class.java]
        binding.viewModel = addShoeViewModel
        binding.lifecycleOwner = this

        binding.saveBtn.setOnClickListener {
            val shoe = addShoeViewModel.getShoe()
            shoesViewModel.addShoe(shoe)
            findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }

        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }

        return binding.root
    }
}