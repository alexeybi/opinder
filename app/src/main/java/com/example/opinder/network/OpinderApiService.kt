package com.example.opinder.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val  BASE_URL = "https://api.opinder.xyz"
//create a Retrofit builder with converter factory and base_url
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//OpinderApiService with different requests
interface OpinderApiService {
    @GET("all-cards")
    fun getOpins():
            Call<String>
}

//create the API object with Retrofit to implement OpinderApiService
object OpinderApi {
   val retrofitService : OpinderApiService by lazy {
       retrofit.create(OpinderApiService::class.java)
   }
}
