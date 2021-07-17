package com.pedro.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedro.newsapp.Fragment.HomeFragment
import com.pedro.newsapp.databinding.ActivityMainBinding
import com.pedro.newsapp.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setFragment()
    }



    private fun setFragment(){
        val fragmentHome = HomeFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame , fragmentHome )
            addToBackStack(null)
            commit()
        }


    }


}