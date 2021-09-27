package com.example.yemeksiparis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparis.databinding.YemekCardItemBinding
import com.example.yemeksiparis.entity.Yemek

class YemekCardAdapter(var mContext: Context, var dataSet:List<Yemek>):RecyclerView.Adapter<YemekCardAdapter.YemekCardViewHolder>()
{

    inner class YemekCardViewHolder(tasarim:YemekCardItemBinding):RecyclerView.ViewHolder(tasarim.root)
    {

      val tasarim=tasarim





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekCardViewHolder {

        val inflater=LayoutInflater.from(mContext)
        val tasarim=YemekCardItemBinding.inflate(inflater)
        return YemekCardViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: YemekCardViewHolder, position: Int) {

       holder.tasarim.textViewYemekAdi.text=dataSet[position].yemek_adi

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}