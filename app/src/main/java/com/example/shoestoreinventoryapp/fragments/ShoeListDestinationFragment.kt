package com.example.shoestoreinventoryapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestoreinventoryapp.R
import com.example.shoestoreinventoryapp.ShoesViewModel
import com.example.shoestoreinventoryapp.databinding.FragmentShoeListDestinationBinding
import com.example.shoestoreinventoryapp.databinding.ShoeItemBinding


class ShoeListDestinationFragment : Fragment() {
      val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentShoeListDestinationBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list_destination, container, false)
        setHasOptionsMenu(true)
        binding.addShoeBtnId.setOnClickListener()
        {
            Navigation.findNavController(it).navigate(R.id.action_shoeListDestinationFragment_to_addShoeFragment)
        }

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            it.forEach()
            {
                val bind=ShoeItemBinding.inflate(LayoutInflater.from(requireContext()),binding.shoeListId,false)
                bind.shoe = it
                binding.shoeListId.addView(bind.root)
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.user_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }
}