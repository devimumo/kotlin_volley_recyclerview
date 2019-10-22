package com.example.second_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launcher.*
import kotlinx.android.synthetic.main.custom_layout.*

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)


        button.setOnClickListener {

             val names=editText.text
            val phone_number=editText2.text
            val navigate=Intent(this,Volley_recycler::class.java)
            navigate.putExtra("name",names)
            navigate.putExtra("phone_number",phone_number)
            startActivity(navigate)

        }


    }
}
