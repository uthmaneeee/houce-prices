package com.example.miniprojet.backend

import javax.inject.Inject

class ModeleBackend @Inject constructor () : ModeleInterface {

    override fun priceCalculator(surfaceTerrain: Int, surfaceBatiment: Int, nbPiece: Int, longitude: Int, latitude: Int): Double {
        return price(surfaceTerrain, surfaceBatiment, nbPiece, longitude, latitude)
    }

    private fun price(surfaceTerrain: Int, surfaceBatiment: Int, nbPiece: Int, longitude: Int, latitude: Int): Double {
        return 888.8
    }


}