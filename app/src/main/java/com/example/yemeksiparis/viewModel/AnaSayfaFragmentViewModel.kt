package com.example.yemeksiparis.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparis.entity.Yemek
import com.example.yemeksiparis.repo.YemeklerDaoRepository

class AnaSayfaFragmentViewModel:ViewModel()
{
    private val yemeklerDaoRepository:YemeklerDaoRepository=YemeklerDaoRepository()
    lateinit var yemekListesi: MutableLiveData<List<Yemek>>


    init {
      yemeklerDaoRepository.tumyemekleriAl()
        tumYemkeleriGetir()

    }

     fun tumYemkeleriGetir()
     {

     yemekListesi=yemeklerDaoRepository.yemekleriGetir()

     }




}