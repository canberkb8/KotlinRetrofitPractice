package com.canberkbbc.recyclerview.Services

import com.canberkbbc.recyclerview.Models.DogModel
import retrofit2.Call
import retrofit2.http.GET

interface IDogService {
    @GET("dogs.json")
     fun getDogList(): Call<List<DogModel>>
}