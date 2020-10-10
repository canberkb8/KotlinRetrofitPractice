package com.canberkbbc.recyclerview.Models


import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?
)