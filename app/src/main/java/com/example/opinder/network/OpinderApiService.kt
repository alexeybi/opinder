package com.example.opinder.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val  BASE_URL = "https://api.opinder.xyz"

//Moshi builder
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Retrofit builder with converter factory and base_url
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

//OpinderApiService with different requests
interface OpinderApiService {
    @GET("all-cards")
    fun getOpins(): Deferred<List<OpinderApiProperties>>
}

//create the API object with Retrofit to implement OpinderApiService
object OpinderApi {
   val retrofitService : OpinderApiService by lazy {
       retrofit.create(OpinderApiService::class.java)
   }
}
