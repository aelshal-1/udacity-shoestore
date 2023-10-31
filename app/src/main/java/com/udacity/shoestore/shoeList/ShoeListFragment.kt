package com.udacity.shoestore.shoeList

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        // for adding menu as setHasOptionMenu is deprecated
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        val args = ShoeListFragmentArgs.fromBundle(requireArguments())
        if (args.shoeName.isNotEmpty()) {
            viewModel.addShoe(args.shoeName, args.companyName, args.shoeSize, args.shoeDescription)
        }


        var index = 0
        for (item in viewModel.shoeList.value!!) {
            val myText = TextView(this.context)
            myText.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
            )
            myText.text = (buildString {
                append(item.name)
                append("|")
                append(item.company)
                append("|")
                append(item.size)

            })
            myText.setTextAppearance(R.style.item_style)
            if (index % 2 == 0)
                myText.setBackgroundColor(Color.CYAN)
            index++

            binding.myLinearLayout.addView(myText)
        }

        binding.detailsButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        )


        return binding.root
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.logout_menu,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
       return true
    }

}