package com.example.yemeksiparis.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.yemeksiparis.R
import com.example.yemeksiparis.databinding.FragmentYemekDetayBinding
import com.example.yemeksiparis.viewModel.YemekDetayFragmentViewModel
import com.example.yemeksiparis.viewModel.YemekSepetiFragmentViewModel


class YemekDetayFragment : Fragment() {

    // YemekDetayFragment için kullanılan Databinding için tasarim değişkeni tanımlandı
   private lateinit var tasarim:FragmentYemekDetayBinding
   private lateinit var viewModel:YemekDetayFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      // tasarim değişkenine  YemekDetayFragment için kullanılan DataBinding sınıfından  layout inflator kullanılarak  deger ataması yapılıyor
      tasarim= FragmentYemekDetayBinding.inflate(inflater)




        // tasarim değişkeninin root metdu kullanılarak onCreateView için gerekli olan View döndürülüuor
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val tempViewModel:YemekDetayFragmentViewModel by viewModels()
        viewModel=tempViewModel
        super.onCreate(savedInstanceState)
    }

}