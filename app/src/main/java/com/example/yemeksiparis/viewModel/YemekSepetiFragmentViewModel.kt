package com.example.yemeksiparis.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparis.entity.SepetYemekler
import com.example.yemeksiparis.entity.Yemek
import com.example.yemeksiparis.repo.YemeklerDaoRepository
import kotlinx.coroutines.CoroutineScope
import kotlin.properties.Delegates

class YemekSepetiFragmentViewModel: ViewModel()
{

    private val yemeklerDaoRepository: YemeklerDaoRepository = YemeklerDaoRepository()
    var count:Int?=0
    var sepetFiyatNonLİve:Int=0
    var sepetFiyat:MutableLiveData<Int> = MutableLiveData()
    lateinit var sepetYemekListesi: MutableLiveData<List<SepetYemekler>>


    init {
        yemeklerDaoRepository.sepetYemekGetir()
        tumSepetYemekleriGetir()

    }

    fun tumSepetYemekleriGetir()
    {

        sepetYemekListesi=yemeklerDaoRepository.sepetYemekleriGetir()
        count= sepetYemekListesi.value?.size
        Log.e("Miktar",count.toString())

        ucretlerHesapla()

    }
    fun yemekSil(yemek_id:Int)
    {

        yemeklerDaoRepository.sepetYemekSil(yemek_id)
        yemeklerDaoRepository.sepetYemekGetir()
        ucretlerHesapla()


    }
    fun ucretlerHesapla()
    {



    }
    fun sepetBosalt(){

        yemeklerDaoRepository.sepetiBosalt()
    }

}

