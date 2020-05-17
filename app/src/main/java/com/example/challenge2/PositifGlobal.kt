package com.example.challenge2


import com.google.gson.annotations.SerializedName

data class PositifGlobal(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String
)