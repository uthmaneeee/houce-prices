package com.example.miniprojet.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.miniprojet.backend.ModeleInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val STATE_KEY_RESULT = "state_key_result"

@HiltViewModel
class CaracteristiqueModel @Inject constructor(state : SavedStateHandle, private val modeleInterface: ModeleInterface): ViewModel(){

    private val _priceResult: MutableLiveData<Int> = state.getLiveData(STATE_KEY_RESULT, 0)
    val priceResult: LiveData<Int> = _priceResult


}