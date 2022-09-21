package com.example.shoestoreinventoryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.shoestoreinventoryapp.R
import com.example.shoestoreinventoryapp.classes.Shoe
import com.example.shoestoreinventoryapp.ShoesViewModel
import com.example.shoestoreinventoryapp.databinding.FragmentAddShoeBinding

// TODO: Rename parameter arguments, choose names that match

class AddShoeFragment : Fragment() {
    val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAddShoeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add_shoe, container, false)

        binding.cancelButtonId.setOnClickListener()
        {
            Navigation.findNavController(it).navigate(R.id.action_addShoeFragment_to_shoeListDestinationFragment)
        }

        binding.saveButtonId.setOnClickListener()
        {
            if(binding.nameId.text!=null && binding.brandId.text!=null &&binding.descriptionId.text!=null&&binding.sizeId.text!=null)
            {
                viewModel.add(
                    Shoe(binding.nameId.text.toString(),
                    binding.brandId.text.toString(),
                    binding.sizeId.text.toString()
                    , binding.descriptionId.text.toString())
                )
                Navigation.findNavController(it).navigate(R.id.action_addShoeFragment_to_shoeListDestinationFragment)
            }
        }

        return binding.root
    }


}