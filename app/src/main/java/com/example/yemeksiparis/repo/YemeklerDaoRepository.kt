package com.example.yemeksiparis.repo

import androidx.lifecycle.MutableLiveData
import com.example.yemeksiparis.entity.Yemek
import com.example.yemeksiparis.entity.YemeklerResponse
import com.example.yemeksiparis.retrofit.ApiUtilis
import retrofit2.Callback
import com.example.yemeksiparis.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Response

class YemeklerDaoRepository
{
    private var yemekListesi:MutableLiveData<List<Yemek>>
    private val yemeklerDaoInterface:YemeklerDaoInterface

    init {
     yemeklerDaoInterface=ApiUtilis.getYemeklerDaoInterface()
     yemekListesi=MutableLiveData()

    }
    fun yemekleriGetir():MutableLiveData<List<Yemek>>{

        return yemekListesi
    }
    fun tumyemekleriAl()
    {

     yemeklerDaoInterface.tumYemekleriGetir().enqueue(object:Callback<YemeklerResponse>{
         override fun onResponse(
             call: Call<YemeklerResponse>?,
             response: Response<YemeklerResponse>?
         ) {

             if (response != null) {
                 yemekListesi.value=response.body().yemekler
             }
         }

         override fun onFailure(call: Call<YemeklerResponse>?, t: Throwable?) {
             TODO("Not yet implemented")
         }


     })




    }

}