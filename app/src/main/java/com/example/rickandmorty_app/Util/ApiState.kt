
package com.example.rickandmorty_app.Util

import com.example.rickandmorty_app.modelPost.Result
import com.example.rickandmorty_app.modelCharacter.CharacterDTO

sealed class ApiState{
    object Loading : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    class Success(val data:List<Result>) : ApiState()
    class CharacterSucess(val data:CharacterDTO) : ApiState()
    object Empty : ApiState()
}
