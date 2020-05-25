package com.ctrl.demolivedata.note.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation

import com.ctrl.demolivedata.R
import com.ctrl.demolivedata.note.db.Note
import com.ctrl.demolivedata.note.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch


class AddNoteFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_save.setOnClickListener { view ->
            val noteTitle = edit_text_title.text.toString().trim()
            val noteBody =edit_text_note.text.toString().trim()
            if(noteTitle.isEmpty()){
                edit_text_title.error="title required"
                edit_text_title.requestFocus()
                return@setOnClickListener
            }

            if(noteBody.isEmpty()){
                edit_text_note.error="note requored"
                edit_text_note.requestFocus()
                return@setOnClickListener
            }

            launch {
                val note = Note(noteTitle,noteBody)
               // saveNote(note)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    it.toast("Note Save")

                    val action = AddNoteFragmentDirections.actionSaveNote()
                    Navigation.findNavController(view).navigate(action)
                }
            }


        }
    }
   /* private fun saveNote(note : Note){
        class SaveNote : AsyncTask<Void,Void, Void>(){
            override fun doInBackground(vararg params: Void?): Void ?{
               NoteDatabase(activity!!).getNoteDao().addNote(note)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(activity,"Note Saved",Toast.LENGTH_LONG).show()
            }

        }
        SaveNote().execute()

    }
*/
}
