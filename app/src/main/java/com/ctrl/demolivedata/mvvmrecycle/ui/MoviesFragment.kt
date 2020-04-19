package com.ctrl.demolivedata.mvvmrecycle.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.ctrl.demolivedata.R
import com.ctrl.demolivedata.mvvmrecycle.util.RecyclerViewClickListener
import com.ctrl.demolivedata.mvvmrecycle.data.models.Movie
import com.ctrl.demolivedata.mvvmrecycle.network.MovieApi
import com.ctrl.demolivedata.mvvmrecycle.repositories.MovieRepository
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment(),
    RecyclerViewClickListener {

private  lateinit var factory : MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

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
            MovieRepository(api)
        factory =
            MoviesViewModelFactory(
                repository
            )
        viewModel = ViewModelProviders.of(this,factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movie ->
                recycler_view_movies.also {
                    it.layoutManager =LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter =
                        MoviesAdapter(
                            movie,
                            this
                        )

                }


        })


    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {
        when(view.id){
            R.id.button_book ->{
               // Toast.makeText(this,"Button clicked",Toast.LENGTH_LONG).show()
            }
        }
    }


}
































