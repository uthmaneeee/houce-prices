package com.example.miniprojet.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.miniprojet.R
import com.example.miniprojet.databinding.CaracteristiqueFragmentBinding
import com.example.miniprojet.viewModel.CaractViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates


@AndroidEntryPoint
class CaracteristiqueFragment: Fragment(), AdapterView.OnItemSelectedListener  {

    private lateinit var binding: CaracteristiqueFragmentBinding
    private var localType by Delegates.notNull<Int>()
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

        val localTypeList: Spinner = binding.listLocalType
        ArrayAdapter.createFromResource(requireActivity(), R.array.local_type, android.R.layout.simple_spinner_item).also{ adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            localTypeList.adapter = adapter
        }

        localTypeList.onItemSelectedListener = this

        binding.CaractButton.setOnClickListener {
            try {
                val surfaceBat = binding.CaractSurfaceBatText.text.toString().toFloat()
                val surfaceTer = binding.CaractSurfaceTerrainText.text.toString().toFloat()
                val nbPiece = binding.NbPieceText.text.toString().toInt()

                caractViewModel.calcul(surfaceBat, surfaceTer, nbPiece, localType)

                val price = caractViewModel.priceResult.value.toString().toFloat()

                val action = CaracteristiqueFragmentDirections.actionCaracteristiqueFragmentToPriceFragment(surfaceBat, surfaceTer, nbPiece, localType, price)
                findNavController().navigate(action)

            } catch (e: java.lang.NumberFormatException){
                Toast.makeText(activity, "Veuillez saisir des valeurs correctes", Toast.LENGTH_LONG).show()
                Log.d("error", e.toString())
            }
        }

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        val localTypeString = parent.getItemAtPosition(pos).toString()
        if (localTypeString == "Maison"){
            localType = 1
        } else if (localTypeString == "Appartement"){
            localType = 2
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        //Nothing
    }
}