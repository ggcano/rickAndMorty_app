package com.example.rickandmorty_app.Network


import com.example.rickandmorty_app.mdoel.DataRest
import retrofit2.http.GET

interface ApiService {

    //https://rickandmortyapi.com/api/character?page=1
    @GET("character?page=1")
   suspend fun getPost(): DataRest
}