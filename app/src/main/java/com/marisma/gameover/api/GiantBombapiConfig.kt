package com.marisma.gameover.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GiantBombApiConfig {
    companion object {
        // Tu clave de API de GiantBomb
        const val API_KEY = "043819ff56e7d93d16844eca1c686958b7ea3ae7"

        // URL base de la API de GiantBomb
        const val BASE_URL = "https://www.giantbomb.com/api/$API_KEY/"

        // Definición de la instancia de Retrofit para la API de GiantBomb
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
