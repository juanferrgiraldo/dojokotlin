package com.example.juangiraldo49.dojok

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.juangiraldo49.dojok.database.dbHelper
import com.example.juangiraldo49.dojok.model.Note
import kotlinx.android.synthetic.main.activity_newnote.*

class newnote : AppCompatActivity() {
    private var database : dbHelper?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newnote)

        guardar.setOnClickListener{
            val title = titulo.text.toString()
            var body = texto.text.toString()

            var note = Note(title,body)
            database = dbHelper(this)
            database!!.insertNote(note)

            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
        salir.setOnClickListener {
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
    }
}
