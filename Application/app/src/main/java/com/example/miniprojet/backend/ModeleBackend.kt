package com.example.miniprojet.backend

import javax.inject.Inject

class ModeleBackend @Inject constructor () : ModeleInterface {

    override fun priceCalculator(surfaceBatiment: Float, surfaceTerrain: Float, nbPiece: Int, localType: Int): Float {
        return price(surfaceBatiment, surfaceTerrain, nbPiece, localType)
    }

    private fun price(surfaceBatiment: Float, surfaceTerrain: Float, nbPiece: Int, localType: Int): Float {
        val price = (surfaceBatiment*251.674988 + surfaceTerrain*7.70036152 + nbPiece*6500.26996 + localType*111825.498) + 18548.241201192286

        return price.toFloat()
    }


}