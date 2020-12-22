package com.kaanb.hextechled.data.network


import com.kaanb.hextechled.data.model.LedModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LEDApiInterface {

    @GET("mini/test")
    fun verilerigetir():Call<LedModel>

}