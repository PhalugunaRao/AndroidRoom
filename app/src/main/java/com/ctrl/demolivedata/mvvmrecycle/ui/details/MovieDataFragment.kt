package com.ctrl.demolivedata.mvvmrecycle.ui.details

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.ctrl.demolivedata.R
import com.ctrl.demolivedata.mvvmrecycle.network.MovieApi
import com.ctrl.demolivedata.mvvmrecycle.repositories.MovieDataRepository
import kotlinx.android.synthetic.main.movies_fragment.*

class MovieDataFragment : Fragment(){

    private  lateinit var factory : MoviesViewModelDataFactory
    private lateinit var viewModel: MoviesDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MovieApi()
        val repository =
            MovieDataRepository(api)
        factory =
            MoviesViewModelDataFactory(
                repository
            )
        viewModel = ViewModelProviders.of(this,factory).get(MoviesDataViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movie ->
            recycler_view_movies.also {
                println("=====${movie.description}  ${movie.name}")
            }


        })


    }



}
































