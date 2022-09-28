package com.example.shortmovieapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.example.shortmovieapp.model.Movie
import com.example.shortmovieapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(private val repository: MovieRepository):ViewModel() {

  private  val _movie = MutableLiveData<com.example.shortmovieapp.Util.Resource>()
  val movie : LiveData<com.example.shortmovieapp.Util.Resource> = _movie

    init {
        getMovies()
    }



    fun getMovies()=viewModelScope.launch {
        _movie.value = com.example.shortmovieapp.Util.Resource.Loading

        repository.getMovies().runCatching {
            _movie.value = com.example.shortmovieapp.Util.Resource.Success(this)
        }
    }
}