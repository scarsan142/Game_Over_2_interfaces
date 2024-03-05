package com.marisma.juegos.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.marisma.gameover.PagerFragment1
import com.marisma.gameover.PagerFragment2

class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int=2
    override fun createFragment(position: Int): Fragment {
        return when (position){
                0 -> PagerFragment1()
                1 -> PagerFragment2()
                else -> throw IllegalArgumentException("Posicion invalida: $position")
        }
    }
}