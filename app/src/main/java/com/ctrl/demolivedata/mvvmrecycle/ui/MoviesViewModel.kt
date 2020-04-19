package com.ctrl.demolivedata.mvvmrecycle.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctrl.demolivedata.mvvmrecycle.data.models.Movie
import com.ctrl.demolivedata.mvvmrecycle.repositories.MovieRepository
import com.ctrl.demolivedata.mvvmrecycle.util.Coroutines
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private lateinit var  job : Job
    private val _movies = MutableLiveData<List<Movie>>()
    val movies :LiveData<List<Movie>>
    get() = _movies


     fun getMovies(){
         job = Coroutines.ioThenMain(
             {repository.getMovies()},
             {_movies.value = it}//it contains Movies
         )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}






















