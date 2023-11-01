package com.udacity.shoestore.shoeList

import android.graphics.Color
import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()
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

       // binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding = FragmentShoeListBinding.inflate(inflater,container,false)

        // for adding menu as setHasOptionMenu is deprecated
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        renderList()

        binding.detailsButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        )


        return binding.root
    }

    private fun renderList() {
        // TextView Layout
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
        )

        var index = 0
        for (item in viewModel.shoeList.value!!) {
            // Item Layout
            val itemLinearLayout = LinearLayout(this.context)
            itemLinearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
            )
            itemLinearLayout.orientation=LinearLayout.HORIZONTAL
            if (index % 2 == 0)
                itemLinearLayout.setBackgroundColor(Color.GREEN)

            //shoeName
            val shoeNameText = TextView(this.context)
            shoeNameText.text = item.name
            layoutParams.weight=3F
            shoeNameText.layoutParams = layoutParams
            shoeNameText.setTextAppearance(R.style.item_style)
            itemLinearLayout.addView(shoeNameText)

            //companyName
            val companyNameText = TextView(this.context)
            companyNameText.text = item.company
            layoutParams.weight= 2F
            companyNameText.layoutParams = layoutParams
            companyNameText.setTextAppearance(R.style.item_style)
            itemLinearLayout.addView(companyNameText)

            //shoeSize
            val shoeSizeText = TextView(this.context)
            shoeSizeText.text = item.size
            layoutParams.weight= 1F
            shoeSizeText.layoutParams = layoutParams
            shoeSizeText.setTextAppearance(R.style.item_style)
            itemLinearLayout.addView(shoeSizeText)

            binding.myLinearLayout.addView(itemLinearLayout)
            index++
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.logout_menu,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
       return true
    }

}