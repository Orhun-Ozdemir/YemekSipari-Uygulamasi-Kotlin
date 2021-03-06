package com.example.yemeksiparis.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.yemeksiparis.R
import com.example.yemeksiparis.adapter.YemekCardAdapter
import com.example.yemeksiparis.databinding.FragmentAnaSayfaBinding
import com.example.yemeksiparis.viewModel.AnaSayfaFragmentViewModel


class AnaSayfaFragment : Fragment() {

    // AnaSayfa Fragment için kullanılan Databinding için değişken tanımlandı
    private lateinit var tasarim:FragmentAnaSayfaBinding
    private lateinit var adapter:YemekCardAdapter
    private lateinit var viewModel:AnaSayfaFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // tasarim değişkenine  AnaSayfa Fragmnet için kullanılan DataBinding sınıfından  layout inflator kullanılarak  deger ataması yapılıyor
       tasarim= FragmentAnaSayfaBinding.inflate(inflater)

        viewModel.yemekListesi.observe(viewLifecycleOwner,{yemekListesi->
            adapter= YemekCardAdapter(requireContext(),yemekListesi)
            tasarim.yemekCardAdapter=adapter
        })

        tasarim.floatingActionButton.setOnClickListener {


            Navigation.findNavController(it).navigate(AnaSayfaFragmentDirections.anaSayfaFragmentToYemekSepetiFragment())
        }





        // tasarim değikeninden view için root metodu kullanılıyor
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        val tempViewModel:AnaSayfaFragmentViewModel by viewModels()
        viewModel=tempViewModel


        super.onCreate(savedInstanceState)
    }


}