package com.pedro.newsapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.newsapp.Adapter.AdapterCnbc
import com.pedro.newsapp.Model.ModelCnbc
import com.pedro.newsapp.Model.dataModelCnbc
import com.pedro.newsapp.Network.ApiService
import com.pedro.newsapp.R
import com.pedro.newsapp.databinding.ActivityMainBinding
import com.pedro.newsapp.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val list = ArrayList<dataModelCnbc>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        getDataCnbc()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       return binding.root
    }



    private fun getDataCnbc(){

        binding.recycleView.setHasFixedSize(true)
        binding.recycleView.layoutManager = LinearLayoutManager(context)

        ApiService.instance.getDataCnbc()
            .enqueue(object : Callback<ModelCnbc> {
                override fun onResponse(call: Call<ModelCnbc>, response: Response<ModelCnbc>) {
                    val listOf = response.body()?.result
                    listOf?.let { list.addAll(it) }

                    val adapter = AdapterCnbc(list)
                    binding.recycleView.adapter = adapter


                }

                override fun onFailure(call: Call<ModelCnbc>, t: Throwable) {

                }

            })


    }


}
