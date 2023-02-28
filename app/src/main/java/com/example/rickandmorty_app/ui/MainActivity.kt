package com.example.rickandmorty_app.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty_app.Adapter.RickAdapter
import com.example.rickandmorty_app.Util.ApiState
import com.example.rickandmorty_app.ViewModel.MainViewModel
import com.example.rickandmorty_app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped

@ActivityRetainedScoped
@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var rickAdapter :RickAdapter


    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerview()

        mainViewModel.getPost()

        lifecycleScope.launchWhenStarted {
            mainViewModel._postStateFlow.collect {it->
            when (it) {
                    is ApiState.Loading -> {
                        binding.recyclerview.isVisible = false
                        binding.progressBar.isVisible = true
                    }
                    is ApiState.Failure -> {
                        binding.recyclerview.isVisible = false
                        binding.progressBar.isVisible = false
                        Log.d("main", "onCreate: ${it.msg}")
                    }
                    is ApiState.Success -> {
                        binding.recyclerview.isVisible = true
                        binding.progressBar.isVisible = false
                        rickAdapter.setData(it.data)
                        rickAdapter.notifyDataSetChanged()
                    }
                    is ApiState.Empty -> {
                        Toast.makeText(this@MainActivity, "Este campo esta vacio", Toast.LENGTH_LONG).show()
                    }

                else -> {}
            }
            }
        }

    }

    private fun initRecyclerview() {
        rickAdapter= RickAdapter(ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=rickAdapter


            rickAdapter.onItemClick = { character ->
               // var number: String= character
               // Toast.makeText(this@MainActivity, character, Toast.LENGTH_SHORT).show()

               goToDetailScreen(character)
            }
        }
    }

    private fun goToDetailScreen(value: String) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("value_id", value)
        startActivity(intent)
    }
}