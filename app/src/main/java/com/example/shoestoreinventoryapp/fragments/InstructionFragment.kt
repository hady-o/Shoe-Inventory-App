package com.example.shoestoreinventoryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestoreinventoryapp.R
import com.example.shoestoreinventoryapp.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_instruction, container, false)
        binding.letsStartedButtonId.setOnClickListener()
        {
            Navigation.findNavController(it).navigate(R.id.action_instructionFragment_to_shoeListDestinationFragment)
        }



        return  binding.root
    }


}