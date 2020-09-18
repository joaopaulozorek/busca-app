package com.joaopaulozorek.buscacbmsc.entities

import com.google.gson.annotations.SerializedName

data class Percentuais(
    @SerializedName("percentual") val percentual : String,
    @SerializedName("distancia") val distancia : String
)