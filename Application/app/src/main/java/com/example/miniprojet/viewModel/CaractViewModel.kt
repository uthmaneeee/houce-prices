package com.example.miniprojet.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.miniprojet.backend.ModeleInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val STATE_KEY_RESULT = "state_key_result"

@HiltViewModel
class CaractViewModel @Inject constructor(state : SavedStateHandle, private val modeleInterface: ModeleInterface): ViewModel(){

    private val _priceResult: MutableLiveData<Float> = state.getLiveData(STATE_KEY_RESULT, 0F)
    val priceResult: LiveData<Float> = _priceResult

    fun calcul(surfaceBat: Float, surfaceTer: Float, nbPiece: Int, Longitude: Float, Latitude: Float){
        try {
            Log.d("test", surfaceBat.toString())
            Log.d("test", surfaceTer.toString())
            Log.d("test", nbPiece.toString())
            Log.d("test", Longitude.toString())
            Log.d("test", Latitude.toString())

            _priceResult.value = modeleInterface.priceCalculator(surfaceBat, surfaceTer, nbPiece, Longitude, Latitude)
            Log.d("test", _priceResult.value.toString())
        } catch (e: java.lang.IllegalArgumentException) {
            _priceResult.value = 0F
        }
    }


}