package com.example.yemeksiparis.retrofit

import com.example.yemeksiparis.entity.YemeklerResponse
import retrofit2.Call
import retrofit2.http.GET

interface YemeklerDaoInterface
{

    @GET("tumYemekleriGetir.php")
    fun tumYemekleriGetir(): Call<YemeklerResponse>


}