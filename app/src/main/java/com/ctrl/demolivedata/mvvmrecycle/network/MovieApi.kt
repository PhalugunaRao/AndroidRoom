package com.ctrl.demolivedata.mvvmrecycle.network

import com.ctrl.demolivedata.mvvmrecycle.data.models.Movie
import com.ctrl.demolivedata.mvvmrecycle.data.models.MovieData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApi {

    @GET("clJGeOiNki?indent=2")
    suspend fun getMovies() : Response<List<Movie>>

    @GET("coYZkSEWrm?indent=2")
    suspend fun getMoviesDetails() : Response<MovieData>


    companion object{
        operator fun invoke(): MovieApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.json-generator.com/api/json/get/")
                .build()
                .create(MovieApi::class.java)

        }
    }
}