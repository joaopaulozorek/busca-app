package com.joaopaulozorek.buscacbmsc.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://apibusca.pythonanywhere.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun perfisService() = retrofit.create(PerfisService::class.java)

}