package com.example.yemeksiparis.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yemeksiparis.entity.*
import com.example.yemeksiparis.retrofit.ApiUtilis
import retrofit2.Callback
import com.example.yemeksiparis.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Response

class YemeklerDaoRepository
{
    private var yemekListesi:MutableLiveData<List<Yemek>>
    var sepeteFiyat:Int=0
    private var sepetyemekListesi:MutableLiveData<List<SepetYemekler>>
    private val yemeklerDaoInterface:YemeklerDaoInterface

    init {
     yemeklerDaoInterface=ApiUtilis.getYemeklerDaoInterface()
     yemekListesi=MutableLiveData()
     sepetyemekListesi= MutableLiveData()

    }
    fun yemekleriGetir():MutableLiveData<List<Yemek>>{

        return yemekListesi
    }
    fun sepetYemekleriGetir():MutableLiveData<List<SepetYemekler>>{

        return sepetyemekListesi
    }
    fun tumyemekleriAl() {

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
    fun sepeteYemekEkle(sepetYemek:SepetYemekler) {
      yemeklerDaoInterface.sepeteYemekEkle(sepetYemek.yemek_id,
          sepetYemek.yemek_adi,
          sepetYemek.yemek_resim_adi,
          sepetYemek.yemek_fiyat,
          sepetYemek.yemek_siparis_adet,
          sepetYemek.kullanici_adi).enqueue(object:Callback<CRUDCevap>{
          override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {

              if (response != null) {
                  if(response.body().success==1)
                  {
                  Log.e("Siparis Eklendi","Sipraş Kaydı Başarıyla Yapıldı")

                  }


              }
          }

          override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
              TODO("Not yet implemented")
          }


      })
    }
    fun sepetYemekGetir() {
        yemeklerDaoInterface.sepetYemkGetir("orhun_ozdemir")
            .enqueue(object : Callback<SepetYemekResponse> {
                override fun onResponse(
                    call: Call<SepetYemekResponse>?,
                    response: Response<SepetYemekResponse>?
                ) {

                    if (response != null) {
                        if (response.body().success == 1) {

                               //Log.e("Yemek List","${response.body().sepet_yemekler.size}")
                                sepetyemekListesi.value = response.body().sepet_yemekler
                                Log.e("Sepet Yemek","Sepet Yemekler Başarıyla Getirildi")

                        }
                    }
                }
                override fun onFailure(call: Call<SepetYemekResponse>?, t: Throwable?) {
                   Log.e("Sepet Yemek","Sepet Yemek Getirilemedi")
                    sepetyemekListesi.value= emptyList()
                }
            })
    }
    fun sepetYemekSil(yemek_id:Int){

        yemeklerDaoInterface.sepettenYemekSil(yemek_id).enqueue(object:Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if(response!=null){
                    if(response.body().success==1){

                        Log.e("Sepet Yemek","Sepetten Yemek Silindi")
                    }
                }
            }
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })


    }
    fun sepetiBosalt(){


        sepetyemekListesi.value?.forEach {


            sepetYemekSil(it.yemek_id)


        }
        sepetyemekListesi.value= emptyList()








    }





}

