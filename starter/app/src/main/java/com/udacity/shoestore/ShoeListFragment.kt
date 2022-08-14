package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding

    private val viewModel: ShoesListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false)
        setHasOptionsMenu(true)

        viewModel.shoesList.observe(viewLifecycleOwner) { shoesList ->
            for (shoe in shoesList) {
                addShoeToView(container, shoe)
            }
        }

        binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_addShoeFragment))

        return binding.root
    }


    private fun addShoeToView(
        container: ViewGroup?,
        shoe: Shoe
    ) {
        val shoeBinding: ShoeItemBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.shoe_item, container, false
        )
        shoeBinding.shoe = shoe
        binding.linearlayoutList.addView(shoeBinding.root)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        return true
    }
}