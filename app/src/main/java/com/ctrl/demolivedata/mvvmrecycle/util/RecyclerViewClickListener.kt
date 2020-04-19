package com.ctrl.demolivedata.mvvmrecycle.util

import android.view.View
import com.ctrl.demolivedata.mvvmrecycle.data.models.Movie

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: Movie)
}