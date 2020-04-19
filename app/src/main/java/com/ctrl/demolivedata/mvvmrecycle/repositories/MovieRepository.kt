package com.ctrl.demolivedata.mvvmrecycle.repositories

import com.ctrl.demolivedata.mvvmrecycle.network.MovieApi

class MovieRepository(
    private val api: MovieApi
) : SafeApiRequest() {
    suspend fun  getMovies() = apiRequest { api.getMovies() }
}