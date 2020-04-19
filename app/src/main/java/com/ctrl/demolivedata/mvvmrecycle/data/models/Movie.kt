package com.ctrl.demolivedata.mvvmrecycle.data.models

data class Movie (
    val id: Int,
    val image: String,
    val is_new: Int,
    val launage: String,
    val like_percentage: Int,
    val rating: String,
    val title: String,
    val type: Int,
    val vote_count: Int
)