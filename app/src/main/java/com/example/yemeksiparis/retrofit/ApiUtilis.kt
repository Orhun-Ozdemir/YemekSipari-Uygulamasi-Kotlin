package com.example.yemeksiparis.retrofit

class ApiUtilis
{
    companion object{
        val baseUrl:String="http://kasimadalan.pe.hu/yemekler/"

       fun getYemeklerDaoInterface():YemeklerDaoInterface
       {

       return RetrofitClient.getClient(baseUrl).create(YemeklerDaoInterface::class.java)

       }


    }
}