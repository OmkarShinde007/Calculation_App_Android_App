package com.example.calculationapp.view

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** RetrofitClient used to provide retrofit instance
 * and create the request using [MathApiService].
 */
object RetrofitClient {
    // MathJS API
    private const val BASE_URL = "https://api.mathjs.org/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val mathApiService: MathApiService by lazy {
        // Create a retrofit request
        retrofit.create(MathApiService::class.java)
    }
}
