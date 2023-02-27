package com.example.rickandmorty_app.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Info(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("pages")
    var pages: Int,
    @SerializedName("prev")
    var prev: String
):Serializable