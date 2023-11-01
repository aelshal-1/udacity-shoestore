package com.udacity.shoestore.shoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.shoeList.ShoeListViewModel


class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var viewModel: ShowDetailsViewModel
    private val shoeListViewMode : ShoeListViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding = FragmentShoeDetailsBinding.inflate(inflater,container,false)

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
                shoeListViewMode.addShoe(viewModel.shoeName.value!!,
                    viewModel.companyName.value!!,
                    viewModel.shoeSize.value!!,
                    viewModel.shoeDetails.value!!)
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
                viewModel.onSaveEventComplete()
            }
        })

        return binding.root
    }

}