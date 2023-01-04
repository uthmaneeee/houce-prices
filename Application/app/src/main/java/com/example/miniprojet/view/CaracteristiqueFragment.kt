package com.example.miniprojet.viewModel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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

        val caractViewModel: CaractViewModel by viewModels()

        binding.CaractButton.setOnClickListener {
            try {
                val surfaceBat = binding.CaractSurfaceBatText.text.toString().toFloat()
                val surfaceTer = binding.CaractSurfaceTerrainText.text.toString().toFloat()
                val nbPiece = binding.NbPieceText.text.toString().toInt()
                val longitude = binding.LongitudeText.text.toString().toFloat()
                val latitude = binding.LatitudeText.text.toString().toFloat()

                caractViewModel.calcul(surfaceBat, surfaceTer, nbPiece, longitude, latitude)

                val price = caractViewModel.priceResult.value.toString().toFloat()

                val action = CaracteristiqueFragmentDirections.actionCaracteristiqueFragmentToPriceFragment(surfaceBat, surfaceTer, nbPiece, longitude, latitude, price)
                findNavController().navigate(action)

            } catch (e: java.lang.NumberFormatException){
                Log.d("test", e.toString())
            }
        }

    }
}