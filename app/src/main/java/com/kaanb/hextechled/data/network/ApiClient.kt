package com.kaanb.hextechled.data.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{

    val BASE_URL = "https://app.hextechgreen.com/"
    private var retrofit:Retrofit? = null
    val client:Retrofit?
        get(){
            if(retrofit == null)
            {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }

}