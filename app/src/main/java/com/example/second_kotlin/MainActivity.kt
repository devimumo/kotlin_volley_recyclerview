package com.example.second_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//recycler_main.layoutManager=
        recycler_main.layoutManager=LinearLayoutManager(this)
        recycler_main.adapter=MianAdapter()



        call_recycler_volley.setOnClickListener {

            val intent=Intent(this,Volley_recycler::class.java)
            startActivity(intent)
        }

    }
}
