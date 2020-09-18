package com.joaopaulozorek.buscacbmsc.entities

import com.google.gson.annotations.SerializedName

data class Recomendacoes(
    @SerializedName("indice") val indice : Int,
    @SerializedName("texto") val texto : String
)