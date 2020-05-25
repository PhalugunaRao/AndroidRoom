package com.ctrl.demolivedata.mvvmrecycle.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ctrl.demolivedata.mvvmrecycle.repositories.MovieDataRepository
import com.ctrl.demolivedata.mvvmrecycle.repositories.MovieRepository
import com.ctrl.demolivedata.mvvmrecycle.ui.MoviesViewModel

class MoviesViewModelDataFactory(
    private val repository: MovieDataRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesDataViewModel(repository) as T
    }
}