package com.canberkbbc.recyclerview.Services

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{
    private const val BASE_URL = "https://fb-retrofitdeneme.firebaseio.com/"
    private var retrofit: Retrofit? = null
    val getDogClient:IDogService
        get() {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(IDogService::class.java)
        }

    val getUserClient:IUserService
        get() {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(IUserService::class.java)
        }
}