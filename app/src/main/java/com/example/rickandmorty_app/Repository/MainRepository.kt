package com.example.rickandmorty_app.Repository


import com.example.rickandmorty_app.Network.ApiServiceImpl
import com.example.rickandmorty_app.modelPost.PostDTO
import com.example.rickandmorty_app.modelCharacter.CharacterDTO
import com.example.rickandmorty_app.modelPost.Info
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor( val apiServiceImpl: ApiServiceImpl) {

    fun getPost(page:String):Flow<PostDTO> = flow {
        emit(apiServiceImpl.getPost(page))
    }.flowOn(Dispatchers.IO)

    fun getCharacter(id:String):Flow<CharacterDTO> = flow {
        emit(apiServiceImpl.getCharacter(id))
    }.flowOn(Dispatchers.IO)



}