package com.example.challenge2.data

import com.example.challenge2.CovidProvItem
import retrofit2.Call
import retrofit2.http.GET

interface CovidProvService {

    @GET("attribute")
    fun getCovidProv():Call<List<CovidProvItem>>

}