package com.ctrl.demolivedata.mvvmrecycle.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ctrl.demolivedata.mvvmrecycle.repositories.MovieRepository

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(
    private val repository: MovieRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T
    }
}