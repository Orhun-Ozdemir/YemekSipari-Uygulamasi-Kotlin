package com.example.yemeksiparis.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.yemeksiparis.R
import com.example.yemeksiparis.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
   private lateinit var tasarim:FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim= FragmentSplashBinding.inflate(inflater)
        tasarim.splashFragment=this




        return tasarim.root
    }


    fun AnaSayfa()
    {

    val direction=SplashFragmentDirections.actionSplashFragmentToAnaSayfaFragment()
        Navigation.findNavController(tasarim.root).navigate(direction)

    }

    
}