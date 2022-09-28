package com.example.shortmovieapp.Util

import com.example.shortmovieapp.model.Movie

sealed class Resource {
    object Loading : Resource()
    class Failure(val msg:String) : Resource()
    class Success(val data:Movie) : Resource()
    object Empty : Resource()
}