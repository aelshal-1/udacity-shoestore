package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment,R.id.welcomeFragment))
        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration)

        Timber.i("onCreate")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController= this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy")
    }
}