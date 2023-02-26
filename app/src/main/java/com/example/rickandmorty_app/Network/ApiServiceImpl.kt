package com.example.rickandmorty_app.Network


import com.example.rickandmorty_app.mdoel.DataRest
import com.example.rickandmorty_app.Network.ApiService
import javax.inject.Inject

class ApiServiceImpl @Inject constructor( val apiService: ApiService) {

    suspend fun getPost(): DataRest = apiService.getPost()
}