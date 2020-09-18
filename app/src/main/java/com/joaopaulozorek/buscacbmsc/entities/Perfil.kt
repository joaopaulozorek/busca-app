package com.joaopaulozorek.buscacbmsc.entities

import com.google.gson.annotations.SerializedName

data class Perfil(
    @SerializedName("perfil") val perfil : String,
    @SerializedName("deslocamento_medio") val deslocamento_medio : String,
    @SerializedName("deslocamento_medio_geral") val deslocamento_medio_geral : String,
    @SerializedName("percentuais") val percentuais : List<Percentuais>,
    @SerializedName("recomendacoes") val recomendacoes : List<Recomendacoes>
)