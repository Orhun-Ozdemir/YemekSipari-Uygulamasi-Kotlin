package com.example.yemeksiparis.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksiparis.R
import com.example.yemeksiparis.adapter.SepetCardAdapter
import com.example.yemeksiparis.databinding.FragmentYemekSepetiBinding
import com.example.yemeksiparis.viewModel.YemekSepetiFragmentViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


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
        tasarim.yemekSepetiFragment=this

        tasarim.recycleViewYemekSepeti.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)


         viewModel.sepetYemekListesi.observe(viewLifecycleOwner, { it ->


             tasarim.recycleViewYemekSepeti.adapter =
                 SepetCardAdapter(requireContext(), it, viewModel)

             var size=0;
             val count=it.size
             var toplam=0
             if(it.isNotEmpty()){
                 it.forEach {

                     toplam+=it.yemek_fiyat*it.yemek_siparis_adet
                     size++

                     if(size==count){
                         tasarim.textViewSepetFiyat.setText(toplam.toString())
                         tasarim.textViewToplamFiyat.setText((toplam+20).toString())

                     }
                 }
             }
             else{

                 //tasarim.textViewSepetFiyat.setText(0.toString())
                     tasarim.textViewSepetFiyat.text=0.toString()
                     tasarim.textViewToplamFiyat.text=0.toString()
                     tasarim.textViewKuriyeFiyat.text=0.toString()
                 //tasarim.textViewKuriyeFiyat.setText(0.toString())

             }





         })




        tasarim.imageButton2.setOnClickListener {

            val alertDialog=AlertDialog.Builder(requireContext())
            alertDialog.setTitle(R.string.tum_sepeti_bosalt)
            alertDialog.setCancelable(false)

            alertDialog.setPositiveButton(R.string.evet){dialogInterface:DialogInterface,i:Int->

                viewModel.sepetBosalt()



            }
            alertDialog.setNegativeButton(R.string.hayır) {dialogInterface: DialogInterface, i: Int ->
                // Hayır butonuna tıklayınca olacaklar
                }
           alertDialog.show()

        }


        // OnCrateView metodu için gerekli olan View  değikeni için tasaraim değişkeninin root metodu kullanılarak değiken döndürülüyor
        return tasarim.root
    }





    override fun onCreate(savedInstanceState: Bundle?) {

        val tempViewModel:YemekSepetiFragmentViewModel by viewModels()
        viewModel=tempViewModel


        super.onCreate(savedInstanceState)
    }


}