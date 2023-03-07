package com.example.rickandmorty_app.Network


import com.example.rickandmorty_app.modelPost.PostDTO
import com.example.rickandmorty_app.modelCharacter.CharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // https://rickandmortyapi.com/api/character?page=1
    @GET("character?/")
    suspend fun getPost(
        @Query("page") id: String
    ): PostDTO


    // https://rickandmortyapi.com/api/character/2
    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: String
    ): CharacterDTO


}