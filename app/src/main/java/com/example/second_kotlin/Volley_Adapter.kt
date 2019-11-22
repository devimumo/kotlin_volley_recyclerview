package com.example.second_kotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_layout.view.*
import kotlinx.android.synthetic.main.video_row.view.*
import java.util.*
import kotlin.collections.ArrayList
import android.widget.Toast.makeText as makeText1

class Volley_Adapter (val user_list:ArrayList<User>) :RecyclerView.Adapter<Volley_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val view=LayoutInflater.from(parent.context).inflate(R.layout.custom_layout,parent,false)


    return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
return  user_list.size   }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



val user_data: User=user_list[position]

    holder.itemview.name.text=user_data.name

        holder.itemview.jina.text=user_data.phone_number

        holder.itemview.date.text=user_data.tarehe

        holder.itemview.amount.text=user_data.amount



        holder.itemview.card_view.setOnClickListener {



val gg:String=position.toString()
            val ff=user_data.name
            holder.itemview.jina.text=gg
Toast.makeText(it.context,"clicked"+ff,Toast.LENGTH_LONG).show()

          //  val intent= Intent(it.context,SecondActivity::class.java)
           // it.context.startActivity(intent)

//val access=SecondActivity()
  //          access.Toast()


        }




    }

    fun removeItem(viewHolder:RecyclerView.ViewHolder )
    {

        user_list.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)

    }

    class  ViewHolder(val itemview: View): RecyclerView.ViewHolder(itemview)
    {

    }




    }









