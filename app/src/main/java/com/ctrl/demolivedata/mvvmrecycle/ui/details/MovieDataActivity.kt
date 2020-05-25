package com.ctrl.demolivedata.mvvmrecycle.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ctrl.demolivedata.R
import com.ctrl.demolivedata.mvvmrecycle.data.models.MovieData
import com.ctrl.demolivedata.mvvmrecycle.network.MovieApi
import com.ctrl.demolivedata.mvvmrecycle.repositories.MovieDataRepository
import com.ctrl.demolivedata.mvvmrecycle.repositories.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieDataActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)

        val repository = MovieDataRepository(
            MovieApi()
        )

        GlobalScope.launch (Dispatchers.Main){
            val movies =repository.getMoviesData()
            println("====${movies}")
        }

    }
}