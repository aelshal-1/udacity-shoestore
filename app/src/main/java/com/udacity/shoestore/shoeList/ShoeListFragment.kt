package com.udacity.shoestore.shoeList

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private lateinit var binding :FragmentShoeListBinding
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

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        var index =0
        for(item in viewModel.shoeList.value!!){
            val myText = TextView(this.context)
            myText.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
            )
            myText.text = item
            myText.setTextAppearance(R.style.item_style)
            if(index % 2 == 0)
                myText.setBackgroundColor(Color.CYAN)
            index++

            binding.myLinearLayout.addView(myText)
        }
        return binding.root
    }

}