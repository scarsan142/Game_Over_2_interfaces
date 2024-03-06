package com.marisma.gameover.data

import com.google.gson.annotations.SerializedName

data class juegoDetalle(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("genre") val genre: String?,
    @SerializedName("studio") val studio: String?,
    @SerializedName("photo") val photo: String
)
