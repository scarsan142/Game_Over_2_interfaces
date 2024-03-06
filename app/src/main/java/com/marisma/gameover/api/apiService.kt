package com.marisma.gameover.api

import com.marisma.gameover.Juego
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface apiService {

    // Declaración de funciones anotadas para acceder a la API.
    @GET("juegos")
    suspend fun getJuegos(): Response<List<Juego>>

    @GET("juegos/{id}")
    suspend fun getJuegoById(@Path("id") id: String): Response<Juego>

}
