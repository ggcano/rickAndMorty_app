package com.example.rickandmorty_app.Network


import com.example.rickandmorty_app.modelPost.PostDTO
import com.example.rickandmorty_app.modelCharacter.CharacterDTO
import javax.inject.Inject

class ApiServiceImpl @Inject constructor( val apiService: ApiService) {

    suspend fun getPost(): PostDTO = apiService.getPost()
    suspend fun getCharacter(id:String): CharacterDTO = apiService.getCharacter(id)
}