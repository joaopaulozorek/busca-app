package com.joaopaulozorek.buscacbmsc.services

import com.joaopaulozorek.buscacbmsc.entities.Perfil
import retrofit2.Call
import retrofit2.http.GET

interface PerfisService {

    @GET("perfis")
    fun getPerfis(): Call<List<Perfil>>

}