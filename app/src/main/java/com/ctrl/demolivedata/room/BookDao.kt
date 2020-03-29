package com.ctrl.demolivedata.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {
    @Insert
    fun insert(book :Book)

    /*@Query("SELECT * FROM books")
    fun getAllBooks():List<Book>
*/
    @get:Query("SELECT * FROM books")
    val allBooks: LiveData<List<Book>>
}