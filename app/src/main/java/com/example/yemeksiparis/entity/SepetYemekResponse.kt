package com.example.yemeksiparis.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class SepetYemekResponse(@SerializedName("sepet_yemekler")@Expose var sepet_yemekler:List<SepetYemekler>,
                               @SerializedName("success")@Expose var success:Int) {
}