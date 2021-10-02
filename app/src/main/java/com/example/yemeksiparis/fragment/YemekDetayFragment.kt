package com.example.yemeksiparis.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.yemeksiparis.R
import com.example.yemeksiparis.databinding.FragmentYemekDetayBinding
import com.example.yemeksiparis.viewModel.YemekDetayFragmentViewModel
import com.example.yemeksiparis.viewModel.YemekSepetiFragmentViewModel
import com.squareup.picasso.Picasso


class YemekDetayFragment : Fragment() {

    // YemekDetayFragment için kullanılan Databinding için tasarim değişkeni tanımlandı
   private lateinit var tasarim:FragmentYemekDetayBinding
   private lateinit var viewModel:YemekDetayFragmentViewModel
   val args:YemekDetayFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      // tasarim değişkenine  YemekDetayFragment için kullanılan DataBinding sınıfından  layout inflator kullanılarak  deger ataması yapılıyor
        tasarim= FragmentYemekDetayBinding.inflate(inflater)
        var bundle:Bundle= Bundle()

        tasarim.yemekDetayToolBarTitle="Yemek Detay Sayfası"
        tasarim.yemek=args.yemekNesnesi
       val url="http://kasimadalan.pe.hu/yemekler/resimler/${args.yemekNesnesi.yemek_resim_adi}"
        Picasso.get().load(url).into(tasarim.imageView2)





        // tasarim değişkeninin root metdu kullanılarak onCreateView için gerekli olan View döndürülüuor
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val tempViewModel:YemekDetayFragmentViewModel by viewModels()
        viewModel=tempViewModel
        super.onCreate(savedInstanceState)
    }

}