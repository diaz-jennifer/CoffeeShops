package com.example.jedc_coffeeshops.model

import androidx.annotation.DrawableRes

data class Cafeteria(
    var nombre: String,
    var direccion: String,
    @DrawableRes var photo: Int
)
