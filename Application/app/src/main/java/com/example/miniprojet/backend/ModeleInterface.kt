package com.example.miniprojet.backend

interface ModeleInterface {

    fun priceCalculator(surfaceTerrain: Int, surfaceBatiment: Int, nbPiece: Int, longitude: Int, latitude: Int): Double
}