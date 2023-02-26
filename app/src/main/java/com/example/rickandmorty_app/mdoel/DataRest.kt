package com.example.rickandmorty_app.mdoel


import com.example.rickandmorty_app.mdoel.Info
import com.example.rickandmorty_app.mdoel.Result
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataRest(
    @SerializedName("info")
    var info: Info,
    @SerializedName("results")
    var results: List<Result>
):Serializable