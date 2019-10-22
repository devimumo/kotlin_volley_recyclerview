package com.example.second_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MianAdapter : RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        //here we create a view
        val layoutInflater=LayoutInflater.from(parent?.context)
        val  cellrow=layoutInflater.inflate(R.layout.video_row,parent,false)

        return   CustomViewHolder(cellrow)

    }

    override fun getItemCount(): Int {
return  40
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

    }
}

class CustomViewHolder (v: View): RecyclerView.ViewHolder(v)
{}