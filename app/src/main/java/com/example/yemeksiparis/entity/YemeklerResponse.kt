package com.example.yemeksiparis.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class YemeklerResponse(
             @SerializedName("yemekler") @Expose var yemekler:List<Yemek>,
             @SerializedName("success")@Expose var success:Int) {





}