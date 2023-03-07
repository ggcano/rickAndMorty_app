package com.example.rickandmorty_app.Network


import com.example.rickandmorty_app.modelPost.PostDTO
import com.example.rickandmorty_app.modelCharacter.CharacterDTO
import com.example.rickandmorty_app.modelPost.Info
import javax.inject.Inject

class ApiServiceImpl @Inject constructor( val apiService: ApiService) {

    suspend fun getPost(page:String): PostDTO = apiService.getPost(page)
    suspend fun getCharacter(id:String): CharacterDTO = apiService.getCharacter(id)

}