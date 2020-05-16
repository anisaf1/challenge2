package com.example.challenge2.data
import com.example.challenge2.CovidIndoItem
import retrofit2.Call
import retrofit2.http.GET

interface CovidIndoService {

    @GET("covid")
    fun getCovid():Call<List<CovidIndoItem>>
}