package com.example.rickandmorty_app.Repository


import com.example.rickandmorty_app.Network.ApiServiceImpl
import com.example.rickandmorty_app.model.DataRest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor( val apiServiceImpl: ApiServiceImpl) {

    fun getPost():Flow<DataRest> = flow {
        emit(apiServiceImpl.getPost())
    }.flowOn(Dispatchers.IO)

}