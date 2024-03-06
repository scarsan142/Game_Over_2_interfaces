package com.marisma.gameover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.marisma.gameover.databinding.FragmentPager2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import preferences

class PagerFragment2 : Fragment() {
    private var _binding: FragmentPager2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPager2Binding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.btnMain.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_mainFragment)
        }

        binding.checkBoxNoMostrarIntroduccion.setOnCheckedChangeListener { _, isChecked ->
            CoroutineScope(Dispatchers.Main).launch {
                val preferences = preferences(requireContext())
                preferences.saveMostrarIntroduccion(!isChecked)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun closeFragment() {
        requireActivity().supportFragmentManager.popBackStack()
    }
}