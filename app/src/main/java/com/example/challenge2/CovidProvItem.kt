package com.example.challenge2

import com.google.gson.annotations.SerializedName

data class CovidProvItem(
    @SerializedName("attributes")
    val attributes: Attributes
) {
    data class Attributes(
        @SerializedName("FID")
        val fID: Int,
        @SerializedName("Kasus_Meni")
        val kasusMeni: Int,
        @SerializedName("Kasus_Posi")
        val kasusPosi: Int,
        @SerializedName("Kasus_Semb")
        val kasusSemb: Int,
        @SerializedName("Kode_Provi")
        val kodeProvi: Int,
        @SerializedName("Provinsi")
        val provinsi: String
    )
}