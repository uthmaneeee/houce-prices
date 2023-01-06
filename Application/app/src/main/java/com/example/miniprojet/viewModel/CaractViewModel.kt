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

    fun calcul(surfaceBat: Float, surfaceTer: Float, nbPiece: Int, localType: Int){
        try {
            _priceResult.value = modeleInterface.priceCalculator(surfaceBat, surfaceTer, nbPiece, localType)
            Log.d("test", _priceResult.value.toString())
        } catch (e: java.lang.IllegalArgumentException) {
            _priceResult.value = 0F
        }
    }


}