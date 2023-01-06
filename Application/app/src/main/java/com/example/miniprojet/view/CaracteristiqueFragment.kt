package com.example.miniprojet.view

import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.fragment.findNavController
import com.example.miniprojet.R
import com.example.miniprojet.databinding.CaracteristiqueFragmentBinding
import com.example.miniprojet.viewModel.CaractViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates


@AndroidEntryPoint
class CaracteristiqueFragment: Fragment(){

    private lateinit var binding: CaracteristiqueFragmentBinding
    private var localType by Delegates.notNull<Int>()


    override fun onResume() {
        super.onResume()
        val localTypeList = resources.getStringArray(R.array.local_type)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.local_list, localTypeList)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        val editText1 = binding.autoCompleteTextView as EditText
        editText1.inputType = InputType.TYPE_NULL
        editText1.text.clear()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = CaracteristiqueFragmentBinding.inflate(inflater)
        val localTypeList = resources.getStringArray(R.array.local_type)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.local_list, localTypeList)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
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
                val localTypeString = binding.autoCompleteTextView.text.toString()

                if (localTypeString == "Maison"){
                    localType = 1
                } else if (localTypeString == "Appartement") {
                    localType = 2
                }

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

}