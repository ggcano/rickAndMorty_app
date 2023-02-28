package com.example.rickandmorty_app.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.rickandmorty_app.Util.ApiState
import com.example.rickandmorty_app.ViewModel.CharacterViewModel
import com.example.rickandmorty_app.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped

@ActivityRetainedScoped
@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: CharacterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getStringExtra("value_id")
        viewModel.getCharacter(id.toString())
        setupGetCharacter()

    }

    @SuppressLint("SetTextI18n")
    private fun setupGetCharacter() {
        lifecycleScope.launchWhenStarted {
            viewModel._characterStateFlow.collect { it ->
                when (it) {
                    is ApiState.Loading -> {
                        binding.txtCharacterName.isVisible = false
                        binding.progressBarDetail.isVisible = true
                    }
                    is ApiState.Failure -> {
                        binding.txtCharacterName.isVisible = false
                        binding.progressBarDetail.isVisible = false
                        Log.d("main", "onCreate: ${it.msg}")
                    }
                    is ApiState.CharacterSucess -> {
                        binding.txtCharacterName.isVisible = true
                        binding.txtCharacterName.text = it.data.name
                        binding.txtCharacterGender.text = it.data.gender
                        binding.txtCharacterEpisode.text =
                            it.data.episode.count().toString() + " episodes"
                        binding.txtCharacterSpecies.text = it.data.species
                        binding.txtCharacterLocation.text = "From " + it.data.location.name

                        Glide.with(this@DetailActivity).load(it.data.image)
                            .into(binding.imageViewCharacterDetail)
                        binding.progressBarDetail.isVisible = false
                    }
                    is ApiState.Empty -> {
                        Toast.makeText(
                            this@DetailActivity, "Este campo esta vacio", Toast.LENGTH_LONG
                        ).show()
                    }

                    else -> {}
                }
            }


        }
    }
}