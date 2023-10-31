package com.udacity.shoestore.shoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding


class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var viewModel: ShowDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        viewModel = ViewModelProvider(this)[ShowDetailsViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        //cancel
        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        )


        //Show Error
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { errorMessage ->
            if(errorMessage.isNotEmpty())
                Toast.makeText(this.context, errorMessage, Toast.LENGTH_LONG).show()
        })


        // Save
        viewModel.saveEventComplete.observe(viewLifecycleOwner, Observer { isSave ->
            if (isSave) {
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment()
                    .apply {
                        shoeName = binding.shoeNameEdit.text.toString()
                        companyName = binding.companyEdit.text.toString()
                        shoeSize = binding.shoeSizeEdit.text.toString().toInt()
                        shoeDescription = binding.detailsEdit.text.toString()
                    })
                viewModel.onSaveEventComplete()
            }
        })

        return binding.root
    }

}