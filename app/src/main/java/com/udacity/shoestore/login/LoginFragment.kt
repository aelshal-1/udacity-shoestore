package com.udacity.shoestore.login

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
import com.udacity.shoestore.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LoginFragment : Fragment() {

    private lateinit var binding :FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this


        viewModel.isLoginSuccess.observe(viewLifecycleOwner, Observer { isSuccess->
            if(isSuccess){
                val email = viewModel.email.value
                val action =LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(email!!)
                findNavController().navigate(action)
                viewModel.onLoginFinishComplete()
            }
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { errorMessage->
            if(errorMessage.isNotEmpty())
                Toast.makeText(this.context,errorMessage,Toast.LENGTH_LONG).show()
        })

        return binding.root
    }

}