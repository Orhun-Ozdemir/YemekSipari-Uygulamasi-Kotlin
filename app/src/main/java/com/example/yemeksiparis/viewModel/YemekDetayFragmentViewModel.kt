package com.example.yemeksiparis.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparis.entity.SepetYemekler
import com.example.yemeksiparis.entity.Yemek
import com.example.yemeksiparis.repo.YemeklerDaoRepository

class YemekDetayFragmentViewModel:ViewModel()
{
    private val yemeklerDaoRepository: YemeklerDaoRepository = YemeklerDaoRepository()
    private var miktar:Int =1
     var miktarLiveData=MutableLiveData<Int>()

    init {
        miktarLiveData.value=miktar

    }


    fun yemekEkle(yemek:Yemek)
    {

         yemeklerDaoRepository.sepeteYemekEkle(SepetYemekler(
             yemek!!.yemek_id,
             yemek!!.yemek_adi,
             yemek!!.yemek_resim_adi,
             yemek!!.yemek_fiyat,
             miktar
         ))


    }
    fun miktarArttır(){

        miktar+=1
        miktarLiveData.value=miktar
    }


    fun miktarAzalt()
    {

        if(miktar!=1)
        {

           miktar-=1
           miktarLiveData.value=miktar
        }

    }



}