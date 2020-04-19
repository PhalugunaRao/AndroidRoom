package com.ctrl.demolivedata.mvvmrecycle.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ctrl.demolivedata.R
import com.ctrl.demolivedata.databinding.RecyclerviewMovieBinding
import com.ctrl.demolivedata.mvvmrecycle.util.RecyclerViewClickListener
import com.ctrl.demolivedata.mvvmrecycle.data.models.Movie

class MoviesAdapter(
    private val movies :List<Movie>,
    private val listener : RecyclerViewClickListener
):RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MoviesViewHolder (
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_movie,
            parent,
            false
        )
        )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.binding.movie = movies[position]


        //WHole click events
        holder.binding.buttonBook.setOnClickListener{
            listener.onRecyclerViewItemClick(holder.binding.buttonBook,movies[position])
        }
    }

    inner class MoviesViewHolder(
        val binding :RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(binding.root)


}