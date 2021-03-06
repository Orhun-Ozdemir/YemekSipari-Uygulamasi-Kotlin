package com.example.yemeksiparis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparis.databinding.YemekCardItemBinding
import com.example.yemeksiparis.entity.Yemek
import com.example.yemeksiparis.fragment.AnaSayfaFragmentDirections
import com.squareup.picasso.Picasso

class YemekCardAdapter(var mContext: Context, var dataSet:List<Yemek>):RecyclerView.Adapter<YemekCardAdapter.YemekCardViewHolder>()
{

    inner class YemekCardViewHolder(tasarim:YemekCardItemBinding):RecyclerView.ViewHolder(tasarim.root)
    {

      var tasarim:YemekCardItemBinding

     init {


         this.tasarim=tasarim
     }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekCardViewHolder {

        val inflater=LayoutInflater.from(mContext)
        val tasarim=YemekCardItemBinding.inflate(inflater)
        return YemekCardViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: YemekCardViewHolder, position: Int) {

        val yemek:Yemek=dataSet[position]
        holder.tasarim.yemek=yemek
        val card=holder.tasarim.yemekCardView


        val url="http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Picasso.get().load(url).into(holder.tasarim.imageViewYemekResim)

        card.setOnClickListener {

            val direction= AnaSayfaFragmentDirections.anaSayfaFragmentToYemekDetayFragment(yemek)
            Navigation.findNavController(it).navigate(direction)


        }



    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}