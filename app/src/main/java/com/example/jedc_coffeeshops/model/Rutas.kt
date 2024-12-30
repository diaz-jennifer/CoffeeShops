package com.example.jedc_coffeeshops.model

sealed class Rutas (val route: String){
    object Main:Rutas("Main")
    object Comentarios:Rutas("Comentarios/{nomCafeteria}"){
        fun creaRutaConParametro(nomCafeteria: String) = "Comentarios/$nomCafeteria"
    }

}