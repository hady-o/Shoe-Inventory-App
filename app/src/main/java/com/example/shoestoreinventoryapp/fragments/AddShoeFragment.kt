package com.example.shoestoreinventoryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        binding.shoe=Shoe("","","","")
        binding.saveButtonId.setOnClickListener()
        {
            if(binding.shoe!!.name!=""&&binding.shoe!!.company!=""&&binding.shoe!!.size!=""&&binding.shoe!!.description!="")
            {
                        viewModel.add(binding.shoe!!)
                        Navigation.findNavController(it).navigate(R.id.action_addShoeFragment_to_shoeListDestinationFragment)
            }
            else
            {
                Toast.makeText(context,"please fill the whole fields",Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }


}