package com.example.second_kotlin

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Second_Adapter  (val data:ArrayList<Data>):
    RecyclerView.Adapter<Second_Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class  ViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView)
    {}
}