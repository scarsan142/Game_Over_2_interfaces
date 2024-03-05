package com.marisma.gameover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marisma.gameover.databinding.FragmentViewPagerBinding
import com.marisma.juegos.adapter.PagerAdapter

class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentViewPagerBinding.inflate(inflater,container,false)
        val adapter = PagerAdapter(requireActivity())

        binding.pager.adapter=adapter


        return binding.root
    }


}