package com.ctrl.demolivedata.mvvmrecycle.repositories

import com.ctrl.demolivedata.mvvmrecycle.network.MovieApi

class MovieDataRepository(
    private val api: MovieApi
) : SafeApiRequest() {
    suspend fun  getMoviesData() = apiRequest { api.getMoviesDetails() }
}