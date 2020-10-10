package com.canberkbbc.recyclerview.Models


import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("name")
    var name: String?,
    @SerializedName("surname")
    var surname: String?,
    @SerializedName("url")
    var url: String?
)