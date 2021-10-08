package com.example.yemeksiparis.retrofit

import com.example.yemeksiparis.entity.CRUDCevap
import com.example.yemeksiparis.entity.SepetYemekResponse
import com.example.yemeksiparis.entity.YemeklerResponse
import retrofit2.Call
import retrofit2.http.*

interface YemeklerDaoInterface
{

    @GET("tumYemekleriGetir.php")
    fun tumYemekleriGetir(): Call<YemeklerResponse>

    @POST("sepeteYemekEkle.php")
    @FormUrlEncoded
    fun sepeteYemekEkle(@Field("yemek_id") yemek_id:Int,
                        @Field("yemek_adi") yemek_adi:String,
                        @Field("yemek_resim_adi") yemek_resim_adi:String,
                        @Field("yemek_fiyat") yemek_fiyat:Int,
                        @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                        @Field("kullanici_adi") kullanici_adi:String,):Call<CRUDCevap>


    @POST("sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun sepetYemkGetir(@Field("kullanici_adi")kullanici_adi:String):Call<SepetYemekResponse>

    @POST("sepettenYemekSil.php")
    @FormUrlEncoded
    fun sepettenYemekSil(@Field("yemek_id")yemek_id:Int):Call<CRUDCevap>


}