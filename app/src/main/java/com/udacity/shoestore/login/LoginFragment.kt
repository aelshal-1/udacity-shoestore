package com.udacity.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
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
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        // I don't know why this format failed to send email as args
//        binding.signinButton.setOnClickListener (
//            Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(binding.emailEdit.text.toString()))
//        )


        binding.signinButton.setOnClickListener { view->
            viewModel.login(binding.emailEdit.text.toString(),binding.passwordEdit.text.toString())
            if(viewModel.isLoginSuccess.value == true){
                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(binding.emailEdit.text.toString()))
            }else{
                Toast.makeText(this.context,viewModel.errorMessage.value,Toast.LENGTH_LONG).show()
            }
        }

        binding.signupButton.setOnClickListener { view->
            viewModel.login(binding.emailEdit.text.toString(),binding.passwordEdit.text.toString())
            if(viewModel.isLoginSuccess.value == true){
                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(binding.emailEdit.text.toString()))
            }else{
                Toast.makeText(this.context,viewModel.errorMessage.value,Toast.LENGTH_LONG).show()
            }
        }


        return binding.root
    }

}