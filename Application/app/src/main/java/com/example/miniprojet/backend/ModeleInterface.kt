package com.example.miniprojet.backend

interface ModeleInterface {

    fun priceCalculator(surfaceBatiment: Float, surfaceTerrain: Float, nbPiece: Int, longitude: Float, latitude: Float): Float
}