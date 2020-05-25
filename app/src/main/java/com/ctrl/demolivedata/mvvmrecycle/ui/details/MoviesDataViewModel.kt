package com.ctrl.demolivedata.mvvmrecycle.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctrl.demolivedata.mvvmrecycle.data.models.Movie
import com.ctrl.demolivedata.mvvmrecycle.data.models.MovieData
import com.ctrl.demolivedata.mvvmrecycle.repositories.MovieDataRepository
import com.ctrl.demolivedata.mvvmrecycle.util.Coroutines
import kotlinx.coroutines.Job

class MoviesDataViewModel (
    private val repository: MovieDataRepository
) : ViewModel() {

    private lateinit var  job : Job
    private val _movies = MutableLiveData<MovieData>()
    val movies : LiveData<MovieData>
        get() = _movies


    fun getMovies(){
        job = Coroutines.ioThenMain(
            {repository.getMoviesData()},
            {_movies.value = it}//it contains Movies
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}







