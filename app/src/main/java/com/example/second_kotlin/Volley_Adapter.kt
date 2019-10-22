package com.example.second_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_layout.view.*
import kotlinx.android.synthetic.main.video_row.view.*

class Volley_Adapter (val user_list:ArrayList<User>): RecyclerView.Adapter<Volley_Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val view=LayoutInflater.from(parent?.context).inflate(R.layout.custom_layout,parent,false)
    return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
return  user_list.size   }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
val user_data: User=user_list[position]

    holder?.itemview.name.text=user_data.name

        holder?.itemview.jina.text=user_data.jina

    }


    class  ViewHolder(val itemview: View): RecyclerView.ViewHolder(itemview)
    {


        val name_text=itemview.findViewById<View>(R.id.name)
        val jina_text=itemview.findViewById<View>(R.id.jina)
    }


}





