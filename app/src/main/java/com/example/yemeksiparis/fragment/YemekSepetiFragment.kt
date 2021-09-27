package com.example.yemeksiparis.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.yemeksiparis.R
import com.example.yemeksiparis.databinding.FragmentYemekSepetiBinding
import com.example.yemeksiparis.viewModel.YemekSepetiFragmentViewModel


class YemekSepetiFragment : Fragment() {

    // YemekSepetiFragment içindeki  tasarima ve tasarim  objelerine erişmek için  DataBinding kullanıldıgı için sayfa için kullanılacak binding sınıfı için değişken tanımlanıyor
    private lateinit var tasarim:FragmentYemekSepetiBinding
    private lateinit var viewModel:YemekSepetiFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // tasarim değikenine FragmentYemekSepetiBinding  degeri atamak için layoutinflator kullanarak  deger atanıyor
        tasarim= FragmentYemekSepetiBinding.inflate(inflater)






        // OnCrateView metodu için gerekli olan View  değikeni için tasaraim değişkeninin root metodu kullanılarak değiken döndürülüyor
        return tasarim.root
    }



    override fun onCreate(savedInstanceState: Bundle?) {

        val tempViewModel:YemekSepetiFragmentViewModel by viewModels()
        viewModel=tempViewModel

        super.onCreate(savedInstanceState)
    }

}