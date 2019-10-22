package com.example.second_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_volley_recycler.*

class Volley_recycler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley_recycler)


recycler_view.layoutManager=LinearLayoutManager(this)



        val users_list=ArrayList<User>()

        users_list.add(User("davy","machakos"))
        users_list.add(User("Faith","Kithimani"))
        users_list.add(User("Mary","Nairobi"))
        users_list.add(User("Justo","JKitengela"))
        users_list.add(User("Daniel","Eldoret"))
        users_list.add(User("Jeffry","Matuu"))
        users_list.add(User("Antony","Mombasa"))
        users_list.add(User("Libi","Kisumu"))

        users_list.add(User("davy","machakos"))
        users_list.add(User("Faith","Kithimani"))
        users_list.add(User("Mary","Nairobi"))
        users_list.add(User("Justo","JKitengela"))
        users_list.add(User("Daniel","Eldoret"))
        users_list.add(User("Jeffry","Matuu"))
        users_list.add(User("Antony","Mombasa"))
        users_list.add(User("Libi","Kisumu"))


        users_list.add(User("davy","machakos"))
        users_list.add(User("Faith","Kithimani"))
        users_list.add(User("Mary","Nairobi"))
        users_list.add(User("Justo","JKitengela"))
        users_list.add(User("Daniel","Eldoret"))
        users_list.add(User("Jeffry","Matuu"))
        users_list.add(User("Antony","Mombasa"))
        users_list.add(User("Libi","Kisumu"))


        users_list.add(User("davy","machakos"))
        users_list.add(User("Faith","Kithimani"))
        users_list.add(User("Mary","Nairobi"))


        users_list.add(User("davy","machakos"))
        users_list.add(User("Faith","Kithimani"))
        users_list.add(User("Mary","Nairobi"))
        users_list.add(User("Justo","JKitengela"))
        users_list.add(User("Daniel","Eldoret"))
        users_list.add(User("Jeffry","Matuu"))
        users_list.add(User("Antony","Mombasa"))
        users_list.add(User("Libi","Kisumu"))



        val adap=Volley_Adapter(users_list)
        recycler_view.adapter=adap

    }
}
