package com.example.yemeksiparis.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.yemeksiparis.R
import com.example.yemeksiparis.databinding.FragmentYemekDetayBinding
import com.example.yemeksiparis.entity.SepetYemekler
import com.example.yemeksiparis.entity.Yemek
import com.example.yemeksiparis.viewModel.YemekDetayFragmentViewModel
import com.example.yemeksiparis.viewModel.YemekSepetiFragmentViewModel
import com.squareup.picasso.Picasso


class YemekDetayFragment : Fragment() {

    // YemekDetayFragment için kullanılan Databinding için tasarim değişkeni tanımlandı
   private lateinit var tasarim:FragmentYemekDetayBinding

   private lateinit var viewModel:YemekDetayFragmentViewModel
   var miktar:Int=1

   val args:YemekDetayFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // tasarim değişkenine  YemekDetayFragment için kullanılan DataBinding sınıfından  layout inflator kullanılarak  deger ataması yapılıyor
        tasarim = FragmentYemekDetayBinding.inflate(inflater)
        tasarim.yemekDetayFragment=this
        var bundle: Bundle = Bundle()


        tasarim.yemek = args.yemekNesnesi
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${args.yemekNesnesi.yemek_resim_adi}"
        Picasso.get().load(url).fit().centerInside().into(
            tasarim.imageViewYemekDetay
        )



        viewModel.miktarLiveData.observe(viewLifecycleOwner, {

            tasarim.miktar=it

        })


        // tasarim değişkeninin root metdu kullanılarak onCreateView için gerekli olan View döndürülüuor
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val tempViewModel:YemekDetayFragmentViewModel by viewModels()
        viewModel=tempViewModel
        super.onCreate(savedInstanceState)
    }

     fun sepetEkle()
    {

        viewModel.yemekEkle(args.yemekNesnesi)
        Toast.makeText(requireContext()," Ürün Sepete Eklendi",Toast.LENGTH_SHORT).show()

    }

    fun miktarArttir()
    {

      viewModel.miktarArttır()


    }
    fun miktarAzalt(){

       viewModel.miktarAzalt()


    }

}