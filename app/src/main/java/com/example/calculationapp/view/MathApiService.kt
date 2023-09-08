package com.example.calculationapp.view

import com.example.calculationapp.model.MathApiRequest
import com.example.calculationapp.model.MathApiResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/** Interface used to create a Post request. */
interface MathApiService {
    @POST("/v4")
    fun evaluateMathExpressions(@Body request: MathApiRequest): Call<MathApiResponse>
}

