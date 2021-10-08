package com.example.yemeksiparis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparis.databinding.YemekCardItemBinding
import com.example.yemeksiparis.databinding.YemekSepetCardItemBinding
import com.example.yemeksiparis.entity.SepetYemekler
import com.example.yemeksiparis.entity.Yemek
import com.example.yemeksiparis.fragment.AnaSayfaFragmentDirections
import com.example.yemeksiparis.viewModel.YemekSepetiFragmentViewModel
import com.squareup.picasso.Picasso

class SepetCardAdapter(var mContext: Context, var dataSet:List<SepetYemekler>,var viewModel:YemekSepetiFragmentViewModel): RecyclerView.Adapter<SepetCardAdapter.SepetCardViewHolder>()
{

    inner class SepetCardViewHolder(tasarim: YemekSepetCardItemBinding): RecyclerView.ViewHolder(tasarim.root)
    {

        var tasarim: YemekSepetCardItemBinding

        init {


            this.tasarim=tasarim
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardViewHolder {

        val inflater= LayoutInflater.from(mContext)
        val tasarim= YemekSepetCardItemBinding.inflate(inflater)
        return SepetCardViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: SepetCardViewHolder, position: Int) {

        val yemek:SepetYemekler =dataSet[position]
        holder.tasarim.sepetYemek=yemek
         //viewModel.sepetFiyat=viewModel.sepetFiyat+yemek.yemek_fiyat

        val url="http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Picasso.get().load(url).into(holder.tasarim.imageViewSepetResim)

        holder.tasarim.imageButtonSil.setOnClickListener {

           viewModel.yemekSil(yemek.yemek_id)

        }





    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}