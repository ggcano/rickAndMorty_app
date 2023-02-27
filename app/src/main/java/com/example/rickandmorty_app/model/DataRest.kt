package com.example.rickandmorty_app.model


import com.example.rickandmorty_app.model.Info
import com.example.rickandmorty_app.model.Result
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataRest(
    @SerializedName("info")
    var info: Info,
    @SerializedName("results")
    var results: List<Result>
):Serializable