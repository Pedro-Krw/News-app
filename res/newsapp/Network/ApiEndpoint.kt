package com.pedro.newsapp.Network

import com.pedro.newsapp.Model.ModelCnbc
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("newupload")
    fun getDataCnbc() : Call<ModelCnbc>

}