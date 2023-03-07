package com.example.rickandmorty_app.ViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_app.Repository.MainRepository
import com.example.rickandmorty_app.Util.ApiState
import com.example.rickandmorty_app.modelPost.Info
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@HiltViewModel
class MainViewModel
@Inject
constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    val _postStateFlow: StateFlow<ApiState> = postStateFlow




    fun getPost(id:String) = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        mainRepository.getPost(id).catch { e ->
            postStateFlow.value = ApiState.Failure(e)
        }.collect { data ->
            postStateFlow.value = ApiState.Success(data.results)
        }
    }

    fun getPage(id: String) {
        viewModelScope.launch {
            postStateFlow.value = ApiState.Loading
            mainRepository.getPost(id).catch { e ->
                postStateFlow.value = ApiState.Failure(e)
            }.collect { data ->
                postStateFlow.value = ApiState.Success(data.results)
            }
        }
    }
/*   fun getLaunch(page:String){
            viewModelScope.launch {
               // postStateFlow.value = ApiState.Loading
                mainRepository.getPost(page).catch { e ->
                    postStateFlow.value = ApiState.Failure(e)
                }.collect { data ->
                   var stre = ApiState.PageSuccess(data.info.next.take(1)).toString()
                    stre =page123
                    postStateFlow.value = ApiState.Success(data.results)

                }
            }
        }*/


}