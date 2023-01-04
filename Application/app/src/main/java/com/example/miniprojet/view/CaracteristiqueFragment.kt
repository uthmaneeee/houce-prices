package com.example.miniprojet.viewModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.miniprojet.databinding.CaracteristiqueFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CaracteristiqueFragment: Fragment()  {

    private lateinit var binding: CaracteristiqueFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CaracteristiqueFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}