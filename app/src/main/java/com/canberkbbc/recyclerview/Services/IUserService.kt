package com.canberkbbc.recyclerview.Services

import com.canberkbbc.recyclerview.Models.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface IUserService {
    @GET("users.json")
    fun getUserList(): Call<Map<String,UserModel>>
}