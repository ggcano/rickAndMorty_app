
package com.example.rickandmorty_app.Util

import com.example.rickandmorty_app.model.Result

sealed class ApiState{
    object Loading : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    class Success(val data:List<Result>) : ApiState()
    object Empty : ApiState()
}
