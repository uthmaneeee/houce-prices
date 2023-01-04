package com.example.miniprojet.backend

import javax.inject.Inject

class ModeleBackend @Inject constructor () : ModeleInterface {

    override fun priceCalculator(surfaceBatiment: Float, surfaceTerrain: Float, nbPiece: Int, longitude: Float, latitude: Float): Float {
        return price(surfaceBatiment, surfaceTerrain, nbPiece, longitude, latitude)
    }

    private fun price(surfaceBatiment: Float, surfaceTerrain: Float, nbPiece: Int, longitude: Float, latitude: Float): Float {
        return 888F
    }


}