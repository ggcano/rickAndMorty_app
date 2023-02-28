package com.example.rickandmorty_app.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_app.Repository.MainRepository
import com.example.rickandmorty_app.Util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel
    @Inject
    constructor(private val mainRepository: MainRepository) : ViewModel() {

        private val characterStateFlow: MutableStateFlow<ApiState> =
            MutableStateFlow(ApiState.Empty)

        val _characterStateFlow: StateFlow<ApiState> = characterStateFlow


        fun getCharacter(id: String) {
            viewModelScope.launch {
                characterStateFlow.value = ApiState.Loading
                mainRepository.getCharacter(id).catch { e ->
                    characterStateFlow.value = ApiState.Failure(e)
                }.collect() { data ->
                    characterStateFlow.value = ApiState.CharacterSucess(data)
                }
            }
        }
    }
