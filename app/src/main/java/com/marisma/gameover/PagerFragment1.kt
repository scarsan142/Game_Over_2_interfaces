package com.marisma.gameover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marisma.gameover.databinding.FragmentPager1Binding

class PagerFragment1 : Fragment() {

    private var _binding : FragmentPager1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPager1Binding.inflate(inflater, container, false)
        return binding.root
    }


}